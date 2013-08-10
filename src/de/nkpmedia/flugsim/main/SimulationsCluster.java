package de.nkpmedia.flugsim.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import de.nkpmedia.flugsim.interpret.Interpret;
import de.nkpmedia.flugsim.sim.Simulation;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SimulationsCluster
{
	public ArrayList<Simulation> simulationsliste = new ArrayList<Simulation>();
	public ArrayList simulationsInt = new ArrayList();
	public ArrayList<Integer> simulationsFortschritt = new ArrayList<Integer>();
	private boolean on = false;
	private int threadsAnzhal;
	private int zeit;
	private MainFrame frame;
	
	public void newCluster(int zeit,int threads, MainFrame mainFrame)
	{
		if(!this.on)
		{
			this.simulationsFortschritt.clear();
			this.simulationsInt.clear();
			this.simulationsliste.clear();
			this.on = true;
			this.threadsAnzhal = threads;
			this.zeit = zeit;
			this.frame = mainFrame;
			this.frame.progressBar.setValue(0);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int simulationen = threads;
			for (int i = 0 ; i < simulationen ; i++)
			{
				this.simulationsliste.add(new Simulation());
				System.out.println("Prozentualer Wert für Simulation:"+i);
				int wert = Integer.parseInt(JOptionPane.showInputDialog(null, "Pozentualer Wer für Simulation "+i+" :"));
				this.simulationsInt.add(wert);
				this.simulationsliste.get(i).setProzent(wert,zeit,this,i);
				this.simulationsFortschritt.add(i, 0);
			
			}
			for (int i = 0 ; i < simulationen ; i++)
			{
				this.simulationsliste.get(i).start();
			
			}
		}
	}
	public void interpretiereCluster(){
		Interpret interpreter = new Interpret();
		interpreter.interpretiere(simulationsliste);
	}
	public synchronized void updateBar(int fortschritt, int nr)
	{
		this.simulationsFortschritt.set(nr, fortschritt);

		float wert = (float) 100 / (float) this.zeit / (float) this.threadsAnzhal;
		float fortschrittswert = 0;
		for (int t = 0 ; t <this.threadsAnzhal ; t++)
		{
			fortschrittswert = fortschrittswert + this.simulationsFortschritt.get(nr) * wert;
		}
		this.frame.progressBar.setValue((int)fortschrittswert + 1 );
	}
}
