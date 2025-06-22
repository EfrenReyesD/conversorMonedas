package com.dimasdev.conversorMonedas.principal;

import com.dimasdev.conversorMonedas.model.conversionMoney;
import com.dimasdev.conversorMonedas.service.ConvierteDatos;
import com.dimasdev.conversorMonedas.service.consumoApi;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.Scanner;

public class principal {
    private Scanner teclado = new Scanner(System.in);
    private consumoApi consumoApi = new consumoApi();

    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/pair/"; //URL incompleta, ingresa la key
    //"https://v6.exchangerate-api.com/v6/KEY/pair/"
    private String conversorBase = "";
    private  String conversorFinal = "";
    private  String cantidadAconvertir = "";

    private final ConvierteDatos conversor = new ConvierteDatos();

    public void menuDeConversion() {
        System.out.println("""
                ***********************************************************************************
                Bienvenido/a al conversor de moneda
                1) Dolar            ==> Peso argentino
                2) Peso Argentino   ==> Dolar
                3) Peso Mexicano    ==> Dolar
                4) Dolar            ==> Peso Mexicano
                5) Peso Colombiano  ==> Dolar
                6) Dolar            ==> Peso Colombiano
                7) Salir
                Eliga una opcion valida:
                ***********************************************************************************
                \n
                """
        );
        var opcion = teclado.nextLine();
        System.out.println(CantidadConversion(Integer.parseInt(opcion)));
        cantidadAconvertir = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE + conversorBase + "/" + conversorFinal + "/" +  cantidadAconvertir);
        int resultado = conversor.obtenerDatos(json, conversionMoney.class).resultadoConversion();


        System.out.println(mensajeFinal(cantidadAconvertir,Integer.parseInt(opcion),String.valueOf(resultado)));
    }


    private  String mensajeFinal(String cantidadAConvertirx, int opcion, String resultado){
        var mensaje = "\n";

        switch (opcion) {
            case 1:
                mensaje += cantidadAConvertirx + " dolares es igual a " + resultado + " pesos argentinos.";
                break;
            case 2:
                mensaje += cantidadAConvertirx + " pesos argentinos es igual a " + resultado + " dolares.";
                break;
            case 3:
                mensaje += cantidadAConvertirx + " pesos mexicanos es igual a " + resultado + " dolars.";
                break;
            case 4:
                mensaje += cantidadAConvertirx + " dolares es igual a " + resultado + " pesos mexicanos.";
                break;
            case 5:
                mensaje += cantidadAConvertirx + " pesos colombianos es igual a " + resultado + " dolars.";
                break;
            case 6:
                mensaje += cantidadAConvertirx + " dolares es igual a " + resultado + " pesos colombianos.";
                break;
            default:
                mensaje += "Error";
        }

        return mensaje;
    }

    private String CantidadConversion(int opcion){
        var mensaje = "\nIndique la cantidad a convertir de -  ";
        switch (opcion){
            case 1:
                mensaje = mensaje + "Dolar a peso argentino: ";
                conversorBase = "USD";
                conversorFinal = "ARS";
                break;
            case 2:
                mensaje = mensaje + "peso algentino a dolar: ";
                conversorBase = "ARS";
                conversorFinal = "USD";
                break;
            case 3:
                mensaje = mensaje + "peso mexicano a dolar: ";
                conversorBase = "MXN";
                conversorFinal = "USD";
                break;
            case 4:
                mensaje = mensaje + "dolar a peso mexicano:  ";
                conversorBase = "USD";
                conversorFinal = "MXN";
                break;
            case 5:
                mensaje = mensaje + "peso colombiano a dolar:  ";
                conversorBase = "COP";
                conversorFinal = "USD";
                break;
            case 6:
                mensaje = mensaje + "dolar a peso colombiano: ";
                conversorBase = "USD";
                conversorFinal = "COP";
                break;
            default:
                mensaje = "Opcion invalida";
        }


        return mensaje;

    }


}
