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
public class Grafico_Dispercion extends JPanel{
    private double [] data;
    private int div;
    private double maxdata;
    public Grafico_Dispercion(double[] data, int div){
        this.data = data;
        this.div = div;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() -10), (this.getWidth()-10), (this.getHeight() -10));
        g.drawLine(10, 10, 10,(this.getHeight() -10));
        g.setColor(Color.BLUE);
        int totaly = 5;
        int totalx = 5;
        maxdata = 0;
        for (int i = 0; i < data.length; i++) {
            maxdata = Double.max(maxdata, data[i]);
        }
        g.setColor(Color.black);
        for (int i = 1, j = this.getHeight() / div; i < div; i++, j += this.getHeight() / div) {
            g.drawLine(10, j, (this.getWidth()), j);
        }
        g.setColor(Color.BLUE);
        for (int i = 0, j = 40; i < data.length; i++, j += this.getWidth() / data.length) {
            double porcent = (data[i] / maxdata) * 100;
            int y = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            g.fillArc(j, y,25,25,0,360);
        }
    }
    
    public String[] setStringDivEtiquets() {
        String[] etiquets = new String[div];
        for (int i = 0, j = 100/div; i < div; i++, j+=100/div) {
            etiquets[i] = Integer.toString((int) ((maxdata/100)*(double)j));
        }
        return etiquets;
    }
}
