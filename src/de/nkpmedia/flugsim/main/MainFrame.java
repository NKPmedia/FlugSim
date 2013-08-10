package de.nkpmedia.flugsim.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame implements Runnable, MouseListener
{

	public JFrame frame;
	protected SimulationsCluster cluster;
	private JButton btnBerechnen;
	private JButton btnInterpretieren;
	private JFormattedTextField frmtdtxtfldThreads;
	private JFormattedTextField frmtdtxtfldZeitschritte;
	public JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public MainFrame()
	{
		System.out.println("Test");
		this.cluster = new SimulationsCluster();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFortschritt = new JLabel("Fortschritt");
		lblFortschritt.setBounds(12, 12, 90, 15);
		frame.getContentPane().add(lblFortschritt);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(108, 12, 320, 15);
		frame.getContentPane().add(progressBar);
		
		btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addMouseListener(this);
		btnBerechnen.setBounds(311, 233, 117, 25);
		frame.getContentPane().add(btnBerechnen);
		
		btnInterpretieren = new JButton("Interpretieren");
		btnInterpretieren.addMouseListener(this);
		btnInterpretieren.setBounds(164, 233, 135, 25);
		frame.getContentPane().add(btnInterpretieren);
		
		JLabel lblThreads = new JLabel("Threads");
		lblThreads.setBounds(12, 39, 90, 15);
		frame.getContentPane().add(lblThreads);
		
		JLabel lblZeitschritte = new JLabel("Zeitschritte");
		lblZeitschritte.setBounds(12, 66, 90, 15);
		frame.getContentPane().add(lblZeitschritte);
		
		frmtdtxtfldThreads = new JFormattedTextField();
		frmtdtxtfldThreads.setBounds(108, 37, 124, 19);
		frame.getContentPane().add(frmtdtxtfldThreads);
		
		frmtdtxtfldZeitschritte = new JFormattedTextField();
		frmtdtxtfldZeitschritte.setBounds(108, 64, 124, 19);
		frame.getContentPane().add(frmtdtxtfldZeitschritte);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if(arg0.getSource() == btnBerechnen)
		{
			this.cluster.newCluster(Integer.parseInt(frmtdtxtfldZeitschritte.getText()), Integer.parseInt(frmtdtxtfldThreads.getText()),this);
		}else if(arg0.getSource() == btnInterpretieren)
		{
			this.cluster.interpretiereCluster();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
}
