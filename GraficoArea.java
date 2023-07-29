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
public class GraficoArea extends JPanel{
    private double[] data;
    private double maxdata;
    private int div;
    private Color colorarea;
    //Constructor para hacer un grafico de area
    public GraficoArea(double[] data, double maxdata, int div, Color colorarea){
        this.div = div;
        this.data = data;
        this.maxdata = maxdata;
        this.colorarea = colorarea;
    }
    
    private void makeGraphic(Graphics g){
        g.setColor(Color.red);
        g.drawLine(10, (this.getHeight() - 10), (this.getWidth()), (this.getHeight() - 10));
        g.drawLine(10, 0, 10, (this.getHeight() - 10));
        g.setColor(Color.black);
        int j = this.getHeight() / div;
        for (int i = 1 ; i < div; i++) {
            g.drawLine(10, j, (this.getWidth()), j*1);
        }
        //Crea las cordenadas segun la data enviada dentro del parametro y la variable espaciadora
        g.setColor(Color.BLUE);
        int[] x = new int[data.length+2];
        int[] y = new int[data.length+2];
        x[0] = 10;
        y[0] = this.getHeight()-10;
        int espaciador = this.getWidth() / data.length;
        for (int i = 1; i <= data.length; i++) {
            double porcent = (data[i-1] / maxdata) * 100;
            int ys = (int) Math.abs(this.getHeight() * (porcent / 100) - this.getHeight());
            x[i+1] = espaciador * i;
            y[i+1] = ys;
        }
        x[x.length-1] = this.getWidth();
        y[y.length-1] = this.getHeight()-10;
        //Dibuja un poligono que representara el area de los datos
        g.fillPolygon(x, y, 2+data.length);
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
        makeGraphic(g);
    }
}
