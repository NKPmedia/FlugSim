package de.nkpmedia.flugsim.interpret;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;

import de.nkpmedia.flugsim.sim.Simulation;

public class Interpret
{
	public void interpretiere(ArrayList<Simulation> Simulationen)
	{
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		for(int i = 0 ; i < Simulationen.size();i++)
		{
			XYSeries series1 = new XYSeries(i);
			for(int o = 0; o < Simulationen.get(i).infizierte.size() ; o++)
			{
				series1.add(o, Simulationen.get(i).infizierte.get(o));
			}
			
			dataset2.addSeries(series1);
		}
		XYDotRenderer dot = new XYDotRenderer();
		dot.setDotHeight(5);
		dot.setDotWidth(5);
		
		NumberAxis xax = new NumberAxis("x");
		NumberAxis yax = new NumberAxis("y");
		
		XYPlot plot = new XYPlot(dataset2,xax,yax, dot);
		
		JFreeChart chart2 = new JFreeChart(plot);
		
		// Erstellen eines Ausgabefensters
		ApplicationFrame punkteframe = new ApplicationFrame("Punkte"); //"Punkte" entspricht der Ueberschrift des Fensters

		ChartPanel chartPanel2 = new ChartPanel(chart2);
		punkteframe.setContentPane(chartPanel2);
		punkteframe.pack();
		punkteframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		punkteframe.setVisible(true);
	}
}
