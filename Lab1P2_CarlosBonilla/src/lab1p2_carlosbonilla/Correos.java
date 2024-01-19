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
    
    public Correos(String PW,Date edad,String name){
        Date hoy=new Date();
        long Edad=edad.getTime();
        Long Hoy=hoy.getTime();
        int años=(int)((Edad-Hoy)/(1000*60*60*24*360));
        this.PW=PW;
        this.edad=años;
    }
    public void setPW(String PW) {
        this.PW = PW;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
    
}
