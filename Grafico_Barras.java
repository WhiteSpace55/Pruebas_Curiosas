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
public class Grafico_Barras extends JPanel {

    private double[] data;
    private double maxdata;
    public final static int Cuatro = 4, Cinco = 5;
    private int div;

    public Grafico_Barras(double[] data, double maxdata, int numlinediv) {
        this.data = data;
        this.maxdata = maxdata;
        this.div = numlinediv;
    }

    private void makeGraphic(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        g.setColor(Color.black);
        for (int i = 1, j = this.getHeight() / div; i < div; i++, j += this.getHeight() / div) {
            g.drawLine(10, j, (this.getWidth()), j);
        }
        g.setColor(Color.BLUE);
        for (int i = 0, j = 40; i < data.length; i++, j += this.getWidth() / data.length) {
            double porcent = (data[i] / maxdata) * 100;
            int y = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            g.fillRect(j, y, (this.getWidth() / data.length) / 2, (int) (this.getHeight() * (porcent / 100) - 10));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        makeGraphic(g);
    }

    public String[] getStringDivEtiquets() {
        String[] etiquets = new String[div];
        for (int i = 0, j = 100/div; i < div; i++, j+=100/div) {
            etiquets[i] = Integer.toString((int) ((maxdata/100)*(double)j));
        }
        return etiquets;
    }

}
