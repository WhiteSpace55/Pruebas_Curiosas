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
public class Grafico_Circular extends JPanel {

    private int[] data;
    private Color[] color;
    private double maxnumber;

    public Grafico_Circular(Color[] color, int[] data) {
        this.color = color;
        this.data = data;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        makegrafic(g);
    }

    private void makegrafic(Graphics g) {
        for (int i : data) {
            maxnumber += i;
        }
        double newangle = 0;
        double angle = 0;
        for (int i = 0; i < data.length; i++) {
            g.setColor(color[i]);
            angle = (360 / maxnumber) * (double) data[i];
            g.fillArc(0, 0, this.getWidth(), this.getHeight(), (int) newangle, (int) angle);
            newangle += angle;
        }
    }
    
    public double[] getPorcent(){
        double[] porcent = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            porcent[i] = (data[i] / maxnumber) * 100;
        }
        return porcent;
    }
}
