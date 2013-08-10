package de.nkpmedia.flugsim.main;

import java.io.IOException;

public class Main
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Main main = new Main();
		main.go();
	}
	public void go() throws NumberFormatException, IOException
	{
		System.out.println("Starte die Flugzeugsimulation");
		
		MainFrame window = new MainFrame();
		window.frame.setVisible(true);
	}

}
