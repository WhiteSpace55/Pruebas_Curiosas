/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication19;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Harold
 */
public class GraficoCircular extends JPanel {

    private double[] data;
    private Color[] color;
    private double maxnumber;
    //Constructor para crear un grafico circular
    public GraficoCircular(Color[] color, double[] data) {
        this.color = color;
        this.data = data;
    }
    //Crea el grafico circular
    private void makegrafic(Graphics g) {
        maxnumber = 0;
        for (double i : data) {
            maxnumber += i;
        }
        double newangle = 0;
        double angleinit = 0;
        //Crea todos los arcos segun los parametros dados en e constructor hasta completar el grafico
        for (int i = 0; i < data.length; i++) {
            g.setColor(color[i]);
            newangle = (360 / maxnumber) * (double) data[i];//Calcula el arco que debe pertenecer el data correspondiente con relacion al maznumber
            g.fillArc(0, 0, this.getWidth(), this.getHeight(), (int) angleinit, (int) newangle);
            angleinit += newangle;
        }
    }
    //Devuelve los porcentajes de la data de 1-100
    public double[] getPorcent() {
        double[] porcent = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            porcent[i] = (data[i] / maxnumber) * 100;//
        }
        return porcent;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        makegrafic(g);
    }
}
