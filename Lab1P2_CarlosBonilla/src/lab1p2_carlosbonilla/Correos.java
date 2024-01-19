/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_carlosbonilla;

import java.util.Date;

/**
 *
 * @author lospe
 */
public class Correos {
    private String PW;
    private int edad;
    private String name;
    private int months;
    private int dias;
    public Correos(String PW,Date edad,String name){
        Date hoy=new Date();
        long Edad=edad.getTime();
        Long Hoy=hoy.getTime();
        int años=(int)((Edad-Hoy)/(1000*60*60*24*360));
        int meses =(int)((Edad-Hoy)%(1000*60*60*24*360));
        int Meses= meses/(1000*60*60*24*30);
        int Dias=meses%(1000*60*60*24*30);
        this.dias=Dias/(1000*60*60*24);
        this.months=Meses;
        this.PW=PW;
        this.edad=años;
        this.name=name;
    }
    public void setPW(String PW) {
        this.PW = PW;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setMonths(int Meses) {
        this.months =Meses;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPW() {
        return PW;
    }

    public int getEdad() {
        return edad;
    }

    public String getName() {
        return name;
    }

    public int getMonths() {
        return months;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
}
