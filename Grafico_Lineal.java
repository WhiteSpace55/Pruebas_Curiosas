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
public class Grafico_Lineal extends JPanel{
    private double[]data;
    private int div;
    private double maxdata;
    public Grafico_Lineal(double[] data, int div, double maxdata){
        this.data = data;
        this.div = div;
        this.maxdata = maxdata;
    }
    private void makeGraphics(Graphics g){
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        g.setColor(Color.black);
        for (int i = 1, j = this.getHeight() / div; i < div; i++, j += this.getHeight() / div) {
            g.drawLine(10, j, (this.getWidth()), j);
        }
        g.setColor(Color.BLUE);
        int[] x = new int[data.length];
        int[] y = new int[data.length];
        for (int i = 0, j = 10; i < data.length; i++, j += this.getWidth() / data.length) {
            double porcent = (data[i] / maxdata) * 100;
            int ys = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            x[i] = j;
            y[i] = ys;
        }
        g.drawPolyline(x, y, data.length);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        makeGraphics(g);
    }
}
