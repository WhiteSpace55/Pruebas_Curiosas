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
public class GraficoLineal extends JPanel{
    private double[]data;
    private int div;
    private double maxdata;
    private Color colorline;
    //Constructor para construir un grafico lineal
    public GraficoLineal(double[] data, int div, double maxdata, Color colorline){
        this.data = data;
        this.div = div;
        this.maxdata = maxdata;
        this.colorline = colorline;
    }
    
    private void makeGraphics(Graphics g){
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        g.setColor(Color.black);
        int j = this.getHeight() / div;
        for (int i = 1 ; i < div; i++) {
            g.drawLine(10, j, (this.getWidth()), j*1);
        }
        g.setColor(colorline);
        int[] x = new int[data.length];
        int[] y = new int[data.length];
        //Crea las cordenadas segun la data enviada dentro del parametro y la variable espaciadora
        int espaciadora = this.getWidth() / data.length;
        for (int i = 1; i <= data.length; i++) {
            double porcent = (data[i-1] / maxdata) * 100;
            int ys = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            x[i] = espaciadora*i;
            y[i] = ys;
        }
        g.drawPolyline(x, y, data.length);//Crea la linea segun las coordenadas aportadasS
    }
    //Obtienes las etiquetas de las lineas divisoras 
    public String[] getStringDivEtiquets() {
        String[] etiquets = new String[div];
        int j = 100/div;
        for (int i = 1; i <= div; i++) {
            etiquets[i-1] = Integer.toString((int) ((maxdata/100)*(double)(j*i)));
        }
        return etiquets;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        makeGraphics(g);
    }
}
