package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.Observable;
import java.util.Observer;


class JugPuzzlePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField tf;
	JTextField tf1;
	JProgressBar progressBar;
	JButton jugbutton;
	public int counter=0;
	
	/*
	 * Initializes the jugPuzzle panel
	 */
	public JugPuzzlePanel(int button){
		// Method of JComponent
		setMinimumSize(new Dimension(100,100));
		progressBar = new JProgressBar(0,100);
        progressBar.setForeground (new Color (0, 0, 255));
        progressBar.setBackground (new Color (255, 255,255));

    	jugbutton = new JButton("Jug " + Integer.toString(button));
    	jugbutton.setBackground(Color.WHITE);
    	jugbutton.setForeground(Color.BLUE);

    	Border line = new LineBorder(Color.BLUE);
    	Border margin = new EmptyBorder(5, 15, 5, 15);
    	Border compound = new CompoundBorder(line, margin);
    	jugbutton.setBorder(compound);
        this.setBackground(Color.WHITE);
		add(progressBar);
		add(jugbutton);
		
	}
	/*
	 * Will return the JProgressBar in the panel.
	 * return type: JProgressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}
	
}
