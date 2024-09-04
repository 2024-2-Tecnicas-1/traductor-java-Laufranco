package com.mycompany.mavenproject6;

import java.util.HashMap;
import java.util.Scanner;

public class Mavenproject6 {

    public static HashMap<Integer, String> obtenerNumeros(String idioma) {
        HashMap<Integer, String> numerosESP = new HashMap<>();
        numerosESP.put(0, "cero");
        numerosESP.put(1, "uno");
        numerosESP.put(2, "dos");
        numerosESP.put(3, "tres");
        numerosESP.put(4, "cuatro");
        numerosESP.put(5, "cinco");
        numerosESP.put(6, "seis");
        numerosESP.put(7, "siete");
        numerosESP.put(8, "ocho");
        numerosESP.put(9, "nueve");
        numerosESP.put(10, "diez");
        numerosESP.put(11, "once");
        numerosESP.put(12, "doce");
        numerosESP.put(13, "trece");
        numerosESP.put(14, "catorce");
        numerosESP.put(15, "quince");

        HashMap<Integer, String> numerosENG = new HashMap<>();
        numerosENG.put(0, "zero");
        numerosENG.put(1, "one");
        numerosENG.put(2, "two");
        numerosENG.put(3, "three");
        numerosENG.put(4, "four");
        numerosENG.put(5, "five");
        numerosENG.put(6, "six");
        numerosENG.put(7, "seven");
        numerosENG.put(8, "eight");
        numerosENG.put(9, "nine");
        numerosENG.put(10, "ten");
        numerosENG.put(11, "eleven");
        numerosENG.put(12, "twelve");
        numerosENG.put(13, "thirteen");
        numerosENG.put(14, "fourteen");
        numerosENG.put(15, "fifteen");

        if (idioma.equalsIgnoreCase("Espanol")) {
            return numerosESP;
        } else if (idioma.equalsIgnoreCase("English")) {
            return numerosENG;
        }
        return null;
    }

    public static HashMap<String, String[]> obtenerTextos() {
        HashMap<String, String[]> mensajes = new HashMap<>();
        mensajes.put("SumaESP", new String[]{"La suma de ", " mas ", " es "});
        mensajes.put("SumaENG", new String[]{"The sum of ", " plus ", " is "});
        mensajes.put("InstruccionesESP", new String[]{"Digite el primer numero (0-100):", "Digite el segundo numero (0-100):"});
        mensajes.put("InstruccionesENG", new String[]{"Enter the first number (0-100):", "Enter the second number (0-100):"});
        return mensajes;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Selecciona el idioma / Select the language (Espanol/English):");
        String idioma = lector.next();

        if (!idioma.equalsIgnoreCase("Espanol") && !idioma.equalsIgnoreCase("English")) {
            System.out.println("Idioma no soportado / Language not supported.");
            return;
        }

        HashMap<Integer, String> numerosESP = obtenerNumeros("Espanol");
        HashMap<Integer, String> numerosENG = obtenerNumeros("English");
        HashMap<String, String[]> textos = obtenerTextos();

        if (numerosESP == null || numerosENG == null || textos == null) {
            System.out.println("Error al obtener datos.");
            return;
        }

        String[] instrucciones = textos.get(idioma.equalsIgnoreCase("Espanol") ? "InstruccionesESP" : "InstruccionesENG");

        System.out.println(instrucciones[0]);
        int numero1 = lector.nextInt();
        System.out.println(instrucciones[1]);
        int numero2 = lector.nextInt();

        int suma = numero1 + numero2;

        String[] mensajeSumaESP = textos.get("SumaESP");
        String[] mensajeSumaENG = textos.get("SumaENG");

        String palabraNum1ESP = numerosESP.get(numero1);
        String palabraNum2ESP = numerosESP.get(numero2);
        String palabraSumaESP = numerosESP.get(suma);

        String palabraNum1ENG = numerosENG.get(numero1);
        String palabraNum2ENG = numerosENG.get(numero2);
        String palabraSumaENG = numerosENG.get(suma);

        String fraseESP = mensajeSumaESP[0] + palabraNum1ESP + mensajeSumaESP[1] + palabraNum2ESP + mensajeSumaESP[2] + palabraSumaESP;
        String fraseENG = mensajeSumaENG[0] + palabraNum1ENG + mensajeSumaENG[1] + palabraNum2ENG + mensajeSumaENG[2] + palabraSumaENG;

        System.out.println(fraseESP);
        System.out.println(fraseENG);
    }
}