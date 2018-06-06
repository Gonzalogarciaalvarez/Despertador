/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package despertador;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Gonzalo
 */

public class Reloj {
    
    Timer timer;
    private int horas, minutos, segundos;
    public static String hms;
    Alarma alrm = new Alarma();

    public Reloj() {

        timer = new Timer();

        timer.schedule(new TicTac(), 0, 1000);
    }

    public class TicTac extends TimerTask {

        @Override
        public void run() {

            Date date = new Date();
            horas = date.getHours();
            minutos = date.getMinutes();
            segundos = date.getSeconds();

            hms = horas + ":" + minutos + ":" + segundos;
            
            Display.textoHora.setText(Reloj.hms);
            
            if (hms.contains(alrm.getHmsa())) {
                Sonido.ReproducirSonido("C:\\Users\\user\\Documents\\NetBeansProjects\\Despertador\\src\\despertador\\ring.wav");
            }
        }
    }
}
