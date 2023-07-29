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
public class GraficoDispercion extends JPanel {

    private double[] data;
    private int div;
    private double maxdata;
    private Color colorpoints;

    //Constror para hacer un grafico de dispercion
    public GraficoDispercion(double[] data, int div, Color colorpoints) {
        this.data = data;
        this.div = div;
        this.colorpoints = colorpoints;
    }

    //Crea el grafico de dispercion
    private void makgraphic(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth() - 10), (this.getHeight() - 10));
        g.drawLine(10, 10, 10, (this.getHeight() - 10));
        g.setColor(Color.BLUE);
        maxdata = 0;
        for (int i = 0; i < data.length; i++) {
            maxdata = Double.max(maxdata, data[i]);
        }
        //Crea lineas divisoras del grafico segun el parametro
        g.setColor(Color.black);
        int divisionaltura = this.getHeight() / div;
        for (int i = 1; i < div; i++) {
            g.drawLine(10, divisionaltura * i, (this.getWidth()), divisionaltura);
        }
        //Crea las puntos y los pone en las cordenadas correspondiente segun la data enviada dentro del parametro
        g.setColor(colorpoints);
        int separador = this.getWidth() / data.length;
        for (int i = 1; i <= data.length; i++) {
            double porcent = (data[i - 1] / maxdata) * 100;//Da un´porcentaje del 1 - 100 segun la data
            int y = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());//Elige la cordenada y segun el porcentaje de la data
            g.fillArc(separador * i, y+12, 24, 24, 0, 360);//Dibuja un punto representado a data[i]
        }
    }

    //Obtienes las etiquetas de las lineas divisoras 
    public String[] getStringDivEtiquets() {
        String[] etiquets = new String[div];
        int j = 100 / div;
        for (int i = 1; i <= div; i++) {
            etiquets[i - 1] = Integer.toString((int) ((maxdata / 100) * (double) (j * i)));
        }
        return etiquets;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        makgraphic(g);
    }
}
