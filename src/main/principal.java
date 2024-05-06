package main;

import Records.Moneda;
import utils.ConsultarCambio;
import utils.RealizarCambio;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 7) {
            try {
                System.out.print("""
                        _______________________________________
                        | Bienvenido/a al conversor de moneda |
                        ---------------------------------------
                                        
                        ---------[Opciones]---------
                        [1] Dólar -> Peso argentino
                        [2] Peso argentino -> Dólar
                        [3] Dólar -> Real brasileño
                        [4] Real brasileño -> Dólar
                        [5] Dólar -> Peso colombiano
                        [6] Peso colombiano -> Dólar
                        [7] Salir del programa
                        -----------------------------
                        Seleccione una opción
                        """);
                System.out.print("-> ");
                opcion = Integer.parseInt(keyboardInput.nextLine());
                if (opcion > 7){
                    System.out.println("¡La opcion ingresada no existe!");
                }else{
                    ConsultarCambio consulta = new ConsultarCambio();
                    Moneda moneda = consulta.buscarMoneda(opcion);
                    System.out.print("Ingrese la moneda a cambiar -> ");
                    double entradaMoneda = Double.parseDouble(keyboardInput.nextLine());
                    RealizarCambio cambio = new RealizarCambio();
                    System.out.println("El tipo de cambio es -> " + cambio.cambioMoneda(moneda,entradaMoneda));
                }
            }catch (NumberFormatException e) {
                System.out.println("¡Opción no valida (" + e.getMessage() + ")!");
            }
        }
        System.out.println("¡Programa finalizado!");
    }
}
