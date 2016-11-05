package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class PingText extends JWindow{




	private static final long serialVersionUID = 1L;

	JLabel jl;
	Font f;


	public PingText(){

		this.setBackground(new Color(0, 0, 0, 0));
		this.setAlwaysOnTop(true);
		// Without this, the window is draggable from any non transparent
		// point, including points  inside textboxes.
		this.getRootPane().putClientProperty("windows.awt.draggableWindowBackground", false);
		this.getContentPane().setLayout(new java.awt.BorderLayout());
		this.setVisible(true);
		//this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-100), 0);
		this.pack();
		this.setFocusable(false);
	}

	public void printNumber(int ping){

		this.getContentPane().removeAll();
		jl = new JLabel();
		if(ping == 0){
			this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200), 0);
			jl = new JLabel("Connection Error");
			f = new Font("Fixedsys", Font.PLAIN, 25);
		}else{
			this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()-100), 0);
			jl = new JLabel(ping+"ms");
			f = new Font("Fixedsys", Font.PLAIN, 25);
		}
		jl.setFont(f);
		jl.setForeground(Color.GRAY);
		this.getContentPane().add(jl, java.awt.BorderLayout.NORTH);
		this.pack();

	}
}
