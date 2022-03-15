package com.company;
import java.util.Random;
import java.io.*;
///Class PASSWORD
//Se crea la clase password con sus constructores, metodos , getters & sekkers en un archivo aparte, el mismo sera exportado al main.java
public class Password {
    //Attributes
    private int longitud;
    private String contraseña;

    //Costructors
    //Constructor por ingreso de longitud
    public Password(int longitud) {
        this.longitud = longitud;
        this.contraseña = " ";
    }
    //Constructor por defecto
    public Password() {
        this.longitud = 8;
        this.contraseña = " ";
    }


    //Getters & Setters
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //Methods
    //Metodo donde decide si la contraseña generada es fuerte
    public boolean esFuerte(String pw){
        boolean fuerte=false;
        int valorEnAscii;
        char c;
        int cant=0;
        int cantmay=0;
        int cantmin=0;
        //Se recorre el string letra por letra
        for(int i=0;i<pw.length();i++){
           //Se separa de forma auxiliar el caracter del string
            c=pw.charAt(i);
            //Se lo guarda en una variable entera para saber su valor en codigo ASCII
            valorEnAscii= c;

            //Si esta entre 48 y 57 inclusive es un numero
            if (valorEnAscii>=48 && valorEnAscii<=57)
                cant++;//Se sumara el contador de numeros
            //Si esta entre 65 y 90 inclusive es una letra mayuscula
            if (valorEnAscii>=65 && valorEnAscii<=90)
                cantmay++;//Se sumara el contador de Mayusculas
            //Si esta entre 97 y 122 inclusive es una letra minuscula
            if (valorEnAscii>=97 && valorEnAscii<=122)
                cantmin++;//Se sumara el contador de Minusculas
        }
        if (cant>3 && cantmay>2 && cantmin>1)//Segun lo indicado si cada contado cumple su condicion la contraseña sera fuerte
            fuerte=true;
        return fuerte;

    }
 //Metodo que genera una contraseña de forma aleatoria
    public String generarPassword(){
        int codAscii;
        int i=0;
        StringBuilder pw= new StringBuilder(" ");
        String character=" ";
        //Se creara la contraseña dependiendo de la longitud ingresada o por defecto
        while(i>=0 && i<this.longitud) {
            //El contador solo aumentara si el numero aleatorio cae en alguno de los 3 condicionales , sino seguira generando numeros aleatorios
            //Segun tabla de ASCII del 0 al 122
            codAscii = (int)(Math.random()*122);
            //En el caso de ingresar en alguno de los condicionales se saca el valor de caracter y se lo concatena en la variable "pw" que sera la contraseña
            //Y se incrementa el contador
            //Si esta entre 48 y 57 inclusive es un numero
            if (codAscii>=48 && codAscii<=57){
                character=(Character.toString(codAscii));
                pw.append(character);
                i++;}
            //Si esta entre 65 y 90 inclusive es una letra mayuscula
            if (codAscii>=65 && codAscii<=90)
            {
                character=(Character.toString(codAscii));
                pw.append(character);
                i++;}
            //Si esta entre 97 y 122 inclusive es una letra minuscula
            if (codAscii>=97 && codAscii<=122)
            {
                character=(Character.toString(codAscii));
                pw.append(character);
                i++;}

        }
        return pw.toString();
    }
    //Simplificacion de la impresiones en pantalla
    public void impresionDatos(Password password){
        System.out.println("Su cotraseña es : "+password.getContraseña());
        System.out.println("Su cotraseña tiene una longitud de : "+password.getLongitud()+" caracteres");
    }

}
