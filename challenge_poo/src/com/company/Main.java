package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean fuerte=false;
        int longitud=0;
        int opcion;
        Password password = new Password();
        Scanner teclado = new Scanner(System.in);
        impresionDatos();
        opcion=teclado.nextInt();
        switch (opcion) {
            case 1 : {
                opcionUno(password,longitud,teclado,fuerte);
            }
            break;
            case 2 : {
                opcionDos(password,fuerte);
            }
            break;
            default: System.out.println("Opcion incorrecta");
            break;
        }
        teclado.close();
        }
    //Metodo de impresiones de pantalla para ahorro de codigo en el main
    public static  void impresionDatos(){
        System.out.println("CHALLENGE POO");
        System.out.println("Para ingresar al sistema necesita crear una contraseña aleatoria!");
        System.out.println("GENERACION DE CONTRASEÑA");
        System.out.println("1 Elegir longitud");
        System.out.println("2 Usar longitud por defecto (8 caracteres)");
    }
    //Se simplifica en un metodo la primera opcion para ahorro de codigo en el main
    public static void opcionUno(Password password, int longitud,Scanner teclado, boolean fuerte){
        System.out.println("Ingrese la longitud de caracteres ");
        longitud=teclado.nextInt();
        password.setLongitud(longitud);
        password.setContraseña(password.generarPassword());
        password.impresionDatos(password);
        fuerte=password.esFuerte(password.getContraseña());
        if (fuerte)
            System.out.println("Su contraseña es fuerte");
        else
            System.out.println("Su contraseña es debil");
    }
    //Se simplifica en un metodo la segunda opcion para ahorro de codigo en el main
    public static void opcionDos(Password password,boolean fuerte){
            password.setContraseña(password.generarPassword());
            password.impresionDatos(password);
            fuerte=password.esFuerte(password.getContraseña());
            if (fuerte)
                System.out.println("Su contraseña es fuerte");
            else
                System.out.println("Su contraseña es debil");
        }
}








