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
public class Graficos_Area extends JPanel{
    private double[] data;
    private double maxdata;
    private int div;
    public Graficos_Area(double[] data, double maxdata, int div){
        this.div = div;
        this.data = data;
        this.maxdata = maxdata;
    }
    
    private void makeGraphic(Graphics g){
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        g.setColor(Color.black);
        for (int i = 1, j = this.getHeight() / div; i < div; i++, j += this.getHeight() / div) {
            g.drawLine(10, j, (this.getWidth()), j);
        }
        g.setColor(Color.BLUE);
        int[] x = new int[data.length+2];
        int[] y = new int[data.length+2];
        x[0] = 10;
        y[0] = this.getHeight()-10;
        for (int i = 0, j = 40; i < data.length; i++, j += this.getWidth() / data.length) {
            double porcent = (data[i] / maxdata) * 100;
            int ys = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            x[i+1] = j;
            y[i+1] = ys;
        }
        x[x.length-1] = this.getWidth();
        y[y.length-1] = this.getHeight()-10;
        g.fillPolygon(x, y, 2+data.length);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        makeGraphic(g);
    }
}
