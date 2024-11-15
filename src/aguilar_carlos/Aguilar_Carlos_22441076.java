/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 package aguilar_carlos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Aguilar_Carlos_22441076 {

    public static void main(String[] args) {
        new Juego();
    }

    public static class Juego extends JFrame {
        private String[] palabras = {"LABORATORIO", "ERICK", "UNITEC", "AMAYA", "BARCELONA", "MASCOTA", "PROGRAMACION", "COMPUTADORA", "JAVASCRIPT", "EBENEZER"};
        private String adivinar;
        private String oculta;
        private int oportunidades;
        private JLabel palabra;
        private JLabel mensaje;
        private JTextField letra;

        public Juego() {
            setTitle("Juego adivinar palabra");
            setSize(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            palabra = new JLabel("Adivina la palabra:");
            mensaje = new JLabel("");
            letra = new JTextField(1);

            JButton botonJugar = new JButton("Jugar");
            JButton botonCambiarPalabras = new JButton("Cambiar palabras");

            
            botonJugar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Random rand = new Random();
                    adivinar = palabras[rand.nextInt(palabras.length)];
                    oculta = "";
                    for (int i = 0; i < adivinar.length(); i++) {
                        oculta += "_";
                    }
                    oportunidades = 5;
                    palabra.setText("Palabra: " + oculta);
                    mensaje.setText("Tienes " + oportunidades + " oportunidades.");
                }
            });

            
            botonCambiarPalabras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < palabras.length; i++) {
                        String nuevaPalabra = JOptionPane.showInputDialog(null, "Ingresa la palabra " + (i + 1) + ":");
                        if (nuevaPalabra != null && !nuevaPalabra.isEmpty()) {
                            palabras[i] = nuevaPalabra.toUpperCase();
                        }
                    }
                    mensaje.setText("Palabras cambiadas. Presiona Jugar para iniciar.");
                }
            });

           
            letra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (oportunidades > 0 && !oculta.equals(adivinar)) {
                        char letras = letra.getText().toUpperCase().charAt(0);
                        boolean acierto = false;
                        String nuevaPalabraOculta = "";

                        for (int i = 0; i < adivinar.length(); i++) {
                            if (adivinar.charAt(i) == letras) {
                                nuevaPalabraOculta += letras;
                                acierto = true;
                            } else {
                                nuevaPalabraOculta += oculta.charAt(i);
                            }
                        }

                        if (acierto) {
                            mensaje.setText("¡Le pegaste a un carácter!");
                        } else {
                            oportunidades--;
                            mensaje.setText("No acertaste. Oportunidades restantes: " + oportunidades);
                        }

                        oculta = nuevaPalabraOculta;
                        palabra.setText("Palabra: " + oculta);

                        if (oculta.equals(adivinar)) {
                            mensaje.setText("¡Ganaste! La palabra era: " + adivinar);
                        } else if (oportunidades <= 0) {
                            mensaje.setText("Perdiste. La palabra era: " + adivinar);
                        }

                        letra.setText("");
                    }
                }
            });

            add(palabra);
            add(mensaje);
            add(letra);
            add(botonJugar);
            add(botonCambiarPalabras);

            setVisible(true); 
        }
    }
}


