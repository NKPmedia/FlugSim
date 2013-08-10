package de.nkpmedia.flugsim.sim;

import java.util.ArrayList;

import de.nkpmedia.flugsim.main.SimulationsCluster;

public class Simulation extends Thread
{
	public int prozent;
	public ArrayList<Integer> infizierte = new ArrayList<Integer>();
	private int zeit;
	public boolean ready = false;
	private SimulationsCluster cluster;
	private int nr;

	public synchronized void setProzent(int wert,int zeit, SimulationsCluster simulationsCluster, int i)
	{
		this.prozent = wert;
		this.zeit = zeit;
		this.cluster = simulationsCluster;
		this.nr = i;
		
	}

	public void run()
	{
		Flugzeug flugzeug = new Flugzeug(1000);
		
		for(int i = 0 ; i < this.zeit ; i++)
		{
			flugzeug.nextround(this);
			this.infizierte.add(flugzeug.getErkankte());
			this.cluster.updateBar(i,nr);
		}
		this.ready = true;
		System.out.println("Fertig");
	}

}
