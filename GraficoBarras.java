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
public class GraficoBarras extends JPanel {

    private double[] data;
    private double maxdata;
    public final static int Cuatro = 4, Cinco = 5;
    private int div;
    private Color barracolor;
    //Constructor basico para hacer un grafico estadistico de barras
    public GraficoBarras(double[] data, double maxdata, int numlinediv, Color barracolor) {
        this.data = data;
        this.maxdata = maxdata;
        this.div = numlinediv;
        this.barracolor = barracolor;
    }
    //Crea el grafico de barras
    private void makeGraphic(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));//Las dos lineas siguiente crean el plano del grafico
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        //Crea lineas divisoras del grafico segun el parametro
        g.setColor(Color.black);
        int divisionaltura = this.getHeight() / div;
        for (int i = 1; i < div; i++) {
            g.drawLine(10, divisionaltura*i, (this.getWidth()), divisionaltura);
        }
        //Crea las barras segun la data enviada dentro del parametro
        g.setColor(barracolor);
        int separador = this.getWidth() / data.length;
        for (int i = 1; i <= data.length; i++) {
            double porcent = (data[i-1] / maxdata) * 100;//Da un´porcentaje del 1 - 100 segun la data
            int y = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());//Elige la cordenada y segun el porcentaje de la data
            g.fillRect(separador*i, y, (this.getWidth() / data.length) / 2, (int) (this.getHeight() * (porcent / 100) - 10));//Dibuja una barra representado a data[i]
        }
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
    public void paint(Graphics g) {
        super.paint(g);
        makeGraphic(g);
    }

}
