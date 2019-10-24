/* 
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constantes
        final double TARIFA = 0.15;
        //Variables
        //Variables de Entrada
        int horaEnt;
        int minutoEnt;
        int totalEnt;
        //Variables Randoms
        int horaRnd;
        int minutoRnd;
        int totalRnd;
        //Calculos de diferencias de horas y minutos
        int diferenciaHora;
        int diferenciaMinuto;
        //Variable para el calculo en minutos
        double tiempoMinutos;
        //Variable para el calculo del importe total
        double importe;
        //Cabecera
        System.out.println("Párking Morvedre");
        System.out.println("================");
        //Scanner
        try {
            //Introducir hora y minuto de entrada
            System.out.print("Hora entrada .......: ");
            horaEnt = SCN.nextInt();
            System.out.print("Minuto entrada .....: ");
            minutoEnt = SCN.nextInt();
            //Salto de linea
            System.out.println("---");
            //Mensaje de la hora de entrada
            System.out.printf("Momento entrada ....: %02d:%02dh - Manual%n", 
                    horaEnt, minutoEnt);
            //Horas y minutos randoms
            horaRnd = RND.nextInt(23 - horaEnt + 1) + horaEnt;
            minutoRnd = RND.nextInt(59 - minutoEnt + 1) + minutoEnt;
            //Mensaje de hora y minuto random
            System.out.printf("Momento salida .....: %02d:%02dh - Aleatorio%n", 
                    horaRnd, minutoRnd);
            //Calculo para pasarlo todo a minutos
            totalEnt = horaEnt * 60 + minutoEnt;
            totalRnd = horaRnd * 60 + minutoRnd;
            //Diferencia entre los minutos de entrada y el random
            tiempoMinutos = totalRnd - totalEnt;
            //Salto de linea
            System.out.println("---");
            //Mensaje para la tarifa y su precio
            System.out.printf(Locale.ENGLISH, "Tarifa .............: %.2f €/min%n",
                                                                        TARIFA);
            //Mensaje para el total de minutos facturados
            System.out.printf("Tiempo facturado ...: %.0f minutos ", 
                    tiempoMinutos);
            //Calculo para la diferencia entre horas y minutos por separado
            diferenciaHora = horaRnd - horaEnt;
            diferenciaMinuto = minutoRnd - minutoEnt;
            //Mensaje para mostrar las horas y los minutos de diferencia
            System.out.printf("(" + diferenciaHora + "h" + 
                                            " + " + diferenciaMinuto + "m)%n");
            //Calculo para sacar el total
            importe = tiempoMinutos * TARIFA;
            //Mensaje que muestra el importe total
            System.out.printf(Locale.ENGLISH, "Importe ............: %.2f €%n", 
                                                                       importe);
        } catch (Exception e) {
            //Mensaje por si entrar erronea
            System.out.print("ERROR: Entrada incorrecta");
        } finally {
            SCN.nextLine();
            //Limpiar buffer
        }
    }
}
