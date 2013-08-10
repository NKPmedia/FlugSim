package de.nkpmedia.flugsim.sim;

import java.util.ArrayList;

public class Flugzeug
{

	ArrayList<Mensch> menschen = new ArrayList<Mensch>();
	private int leute;
	
	public Flugzeug(int leute)
	{
		this.leute = leute;
		for(int i = 0 ; i < leute ; i++)
		{
			int zahl = (int) (Math.random() * 100);
			Mensch mensch = new Mensch();
			if(zahl <= 10)
			{
				mensch.setErkrankt(true);
			}
			menschen.add(mensch);
		}
	}

	public int getErkankte()
	{
		int erkrankte = 0;
		for(int i = 0 ; i < menschen.size(); i++)
		{
			if(menschen.get(i).isErkrankt())
			{
				erkrankte++;
			}
		}
		return erkrankte;
		
	}

	public void nextround(Simulation simulation)
	{
		int zufall = (int) (Math.random() * this.leute);
		Mensch mensch = this.menschen.get(zufall);
		if(mensch.isErkrankt())
		{
			int zufall2 = (int) (Math.random() * 100);
			if(zufall2 <= simulation.prozent)
			{
				mensch.setErkrankt(false);
			}
			else
			{
				try
				{
				this.menschen.get(zufall+1).setErkrankt(true);
				}catch(Exception x){}try
				{
				this.menschen.get(zufall-1).setErkrankt(true);
				}catch(Exception x){}
			}
		}
		
	}

}
