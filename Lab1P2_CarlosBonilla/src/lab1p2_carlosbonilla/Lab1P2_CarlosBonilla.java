/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_carlosbonilla;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 *
 * @author lospe
 */
public class Lab1P2_CarlosBonilla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        String fn = "";
        Date edadFecha = new Date();
        boolean validPW;
        ArrayList<Correos> correos = new ArrayList<Correos>();
        boolean dominioValido = false;
        boolean correoValido = false;
        boolean edadSuficiente = false;
        boolean checkValidDate = false;
        String PW = "";
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido/a a mi tarea :)");
        System.out.println("1: Registrar Usuario");
        System.out.println("2: Listar usuarios");
        System.out.println("3: Listar usuarios por dominio");
        System.out.println("4: Salir");
        int menu = sc.nextInt();
        do {
            edadSuficiente = false;
            checkValidDate = false;
            switch (menu) {
                case (1):
                    do {
                        while (checkValidDate == false) {

                            System.out.println("Bienvenido al creador de correos electronicos");
                            System.out.println("ingrese su fecha de nacimiento (dd/MM/yyyy)");
                            fn = input.nextLine();
                            char[] fechaNacimiento = fn.toCharArray();
                            checkValidDate = checkValidDate(fechaNacimiento);
                        }
                        checkValidDate = false;
                        SimpleDateFormat fechaUsuario = new SimpleDateFormat("dd/MM/yyyy");
                        edadFecha = fechaUsuario.parse(fn);
                        Date hoy = new Date();
                        long Hoy = hoy.getTime();
                        Long EdadFecha = edadFecha.getTime();

                        if (Hoy - EdadFecha <= (Hoy - (1000 * 60 * 60 * 24 * 360 * 13))) {
                            edadSuficiente = true;

                        } else {
                            System.out.println("Ingrese una edad valida (mayor de 13 años)");
                        }
                    } while (edadSuficiente = false);

                    System.out.println("Ingrese la direccion que desea que tenga su correo electronico");
                    String correo = input.nextLine();
                    String[] correoTokenizado = correo.split("@");
                    do {
                        correoValido = false;
                        dominioValido = false;
                        if (correoTokenizado.length == 2) {
                            char[] correoNombreCaracteres = correoTokenizado[0].toCharArray();
                            correoValido = VerificarNombre(correo);
                            if ((correoTokenizado[1].equalsIgnoreCase("gmail.com")) || (correoTokenizado[1].equalsIgnoreCase("yahoo.com")) || (correoTokenizado[1].equalsIgnoreCase("icloud.com")) || (correoTokenizado[1].equalsIgnoreCase("outlook.com")) || correoTokenizado[1].equalsIgnoreCase("protonmail.com") || correoTokenizado[1].equalsIgnoreCase("fastmail.com")) {
                                correoValido = true;
                            }
                        } else {
                            correoValido = false;
                        }

                        if (correoValido == false) {
                            System.out.println("ingrese un correo valido (que termine en un dominio valido y que tenga solo caracteres validos)");
                        }
                    } while (correoValido == false);
                    do {
                        validPW = false;
                        System.out.println("Ingrese una contraseña para su correo");
                        PW = input.nextLine();
                        validPW = VerificarPassword(PW);
                        if (validPW == false) {
                            System.out.println("Ingrese una contraseña valida");
                        }
                    } while (validPW == false);
                    Correos nuevoCorreo = new Correos(PW, edadFecha, correo);
                    correos.add(nuevoCorreo);
                    System.out.println("Se a añadido el correo exitosamente");
                    break;
                case (2):
                    Imprimir(correos, 0);
                    break;
                case (3):
                    ImprimirPorDominioGmail(correos, 0);
                    break;
                default:
            }
            System.out.println("REINICIANDO");
            System.out.println("1: Ejercicio 1");
            System.out.println("2: Ejercicio 2");
            System.out.println("3: Ejercicio 3");
            System.out.println("4: Salir");
            menu = sc.nextInt();
        } while (menu != 0);
        System.out.println("Saliendo del programa");
    }

    private static boolean checkValidDate(char[] date) {
        if (date.length != 10
                || (!(date[2] == '/') || !(date[5] == '/'))) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean VerificarNombre(String correo) {
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    private static boolean VerificarPassword(String password) {

        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void Imprimir(ArrayList<Correos> correos, int i) {
        if (i == correos.size() - 1) {

        } else {
            System.out.println("Nombre: " + correos.get(i).getName());
            System.out.println("Edad: " + correos.get(i).getEdad() + " años");
            System.out.println("contraseña: " + correos.get(i).getPW());
            Imprimir(correos, i + 1);
        }
    }

    private static void ImprimirPorDominioGmail(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE GMAIL");
            System.out.println("");
            System.out.println("");
        }
        if (i == correos.size()) {
            ImprimirPorDominioYahoo(correos, 0);
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("gmail.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioGmail(correos, i + 1);
            }

        }
    }

    private static void ImprimirPorDominioYahoo(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE YAHOO");
            System.out.println("");
            System.out.println("");
        }
        if (i == correos.size()) {
            ImprimirPorDominioOutlook(correos, 0);
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("yahoo.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioYahoo(correos, i + 1);
            }

        }

    }

    private static void ImprimirPorDominioOutlook(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE OUTLOOK");
            System.out.println("");
            System.out.println("");
        }
        if (i == correos.size()) {
            ImprimirPorDominioICloud(correos, 0);
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("outlook.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioOutlook(correos, i + 1);
            }

        }

    }

    private static void ImprimirPorDominioICloud(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE ICLOUD");
            System.out.println("");
            System.out.println("");
        }
        if (i == correos.size()) {
            ImprimirPorDominioProtonMail(correos, 0);
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("icloud.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioICloud(correos, i + 1);
            }

        }

    }

    private static void ImprimirPorDominioProtonMail(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE PROTONMAIL");
            System.out.println("");
            System.out.println("");
        }
        if (i == correos.size()) {
            ImprimirPorDominioFastMail(correos, 0);
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("protonmail.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioProtonMail(correos, i + 1);
            }

        }

    }

    private static void ImprimirPorDominioFastMail(ArrayList<Correos> correos, int i) {
        if (i == 0) {
            System.out.println("CORREOS DE FASTMAIL");
            System.out.println("");
            System.out.println("");
        }
        if (i >= correos.size()) {
            
        } else {
            String[] correoActual = correos.get(i).getName().split("@");
            if (correoActual[1].equalsIgnoreCase("fastmail.com")) {
                System.out.println("Nombre: " + correos.get(i).getName());
                System.out.println("Edad: " + correos.get(i).getEdad() + " años");
                System.out.println("contraseña: " + correos.get(i).getPW());
                ImprimirPorDominioFastMail(correos, i + 1);
            }

        }

    }
}
