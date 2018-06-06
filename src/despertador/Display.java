/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package despertador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gonzalo
 */

public class Display extends JFrame implements ActionListener {
    Reloj rel = new Reloj();
    static boolean apagado = false;
    public JButton btnSonido = new JButton("Sonido on/off");
    public JButton btnPosponerAlarma = new JButton("Posponer Alarma");
    public JButton btnSalir = new JButton("Salir");
    public JButton btnHoraAlarma = new JButton("Hora/Alarma");
    public static JTextField textoHora = new JTextField();
    public JTextArea lblHoras = new JTextArea();
    public JPanel pnlMiPanel = new JPanel();

    public Display() {

        super("ALARMA");
        this.setSize(397, 242);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.btnSonido.addActionListener(this);
        this.btnPosponerAlarma.addActionListener(this);
        this.btnSalir.addActionListener(this);
        this.btnSalir.addActionListener(this);
        this.btnHoraAlarma.addActionListener(this);

        FlowLayout DISTRIBUIDOR = new FlowLayout(FlowLayout.LEFT, 30, 30);
        this.pnlMiPanel.setLayout(DISTRIBUIDOR);
        
        this.pnlMiPanel.add(this.textoHora);
        this.pnlMiPanel.add(this.lblHoras);
        this.pnlMiPanel.add(this.btnSonido);
        this.pnlMiPanel.add(this.btnHoraAlarma);
        this.pnlMiPanel.add(this.btnPosponerAlarma);
        this.pnlMiPanel.add(this.btnSalir);

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textoHora)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSonido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPosponerAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHoraAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(textoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSonido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPosponerAlarma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHoraAlarma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.add(this.pnlMiPanel);

    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        if (AE.getSource() == this.btnSonido) {

            if (apagado == false) {
                apagado = true;
            } else {
                apagado = false;
            }
            Sonido.pararSonido(apagado);

        } else if (AE.getSource() == this.btnPosponerAlarma) {
            Alarma.minutos = Alarma.minutos + 5;

        } else if (AE.getSource() == this.btnSalir) {
            System.exit(0);
        } else if (AE.getSource() == this.btnHoraAlarma) {
            Alarma.hmsa();
        }
    }
}
