package ca.utoronto.utm.jugpuzzle;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class JugPuzzleGUIController {
	
	public static JugPuzzle jugPuzzle = new JugPuzzle();
	public static JugPuzzlePanel jug0 = new JugPuzzlePanel(0);
	public static JugPuzzlePanel jug1 = new JugPuzzlePanel(1);
	public static JugPuzzlePanel jug2 = new JugPuzzlePanel(2);
	public static String[] count = new String[2];
	public static TextArea moves;
	public static JButton restart = new JButton("Restart");
	public static JButton quit = new JButton("Quit");
	public static JFrame frame;
	public static int highscore;
	
	/*
	 * Runs the GUIController
	 */
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
	/*
	 * creates the frame and adds all of the panels and other buttons 
	 * to the frame.
	 * Also makes the frame visible.
	 */
	public static void createAndShowGUI() {
			frame = new JFrame("Jug Puzzle");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new FlowLayout());
			frame.getContentPane().setBackground(Color.WHITE);
			//creating the title.
			JTextPane title = new JTextPane();
			title.setText("Jug Puzzle");
			Font f = new Font(Font.SANS_SERIF, 100, 25);
			title.setFont(f);
			title.setEditable(false);
			title.setBackground(null);
			frame.add(title);
			//panel 0
	        frame.add(jug0);
	        jug0.progressBar.setStringPainted(true);
	        jug0.progressBar.setString(Integer.toString(jugPuzzle.getJug(0).getAmount())+"/8");
	        //panel 1
	        frame.add(jug1);
	        jug1.progressBar.setStringPainted(true);
	        jug1.progressBar.setString(Integer.toString(jugPuzzle.getJug(1).getAmount())+"/5");
	        
	        //panel 2
	        jug2.progressBar.setStringPainted(true);
	        jug2.progressBar.setString(Integer.toString(jugPuzzle.getJug(2).getAmount())+"/3");
	        frame.add(jug2);
	        highscore = 0;
	        //moves text
	        moves = new TextArea(3,25);
	        moves.setText("Moves: " + Integer.toString(jugPuzzle.getMoves()) + "\nSelect a Jug to Spill FROM\nHighscore: " + highscore);
	        moves.setEditable(false);
	        
	        JugPuzzleGUIControllerActionListener jugtest0 = new JugPuzzleGUIControllerActionListener(jug0);
	        JugPuzzleGUIControllerActionListener jugtest1 = new JugPuzzleGUIControllerActionListener(jug1);
	        JugPuzzleGUIControllerActionListener jugtest2 = new JugPuzzleGUIControllerActionListener(jug2);
	        jug0.jugbutton.addActionListener(jugtest0);
	        jug1.jugbutton.addActionListener(jugtest1);
	        jug2.jugbutton.addActionListener(jugtest2);
	        //quit button
	        JugPuzzleGUIControllerActionListener quit1 = new JugPuzzleGUIControllerActionListener(jug0);
	        quit.setVisible(true);
	        quit.setActionCommand ("quit");
	        quit.addActionListener(quit1);
	        quit.setBackground(Color.RED);
	        frame.setLocationRelativeTo(null);
	        //restart button
	        restart.setVisible(true);
	        restart.setActionCommand("restart");
	        restart.addActionListener(quit1);
	        restart.setBackground(Color.GRAY);
	        restart.setForeground(Color.WHITE);
	        Border line = new LineBorder(Color.BLACK);
	    	Border margin = new EmptyBorder(5, 15, 5, 15);
	    	Border compound = new CompoundBorder(line, margin);
	    	restart.setBorder(compound);
	    	quit.setBorder(compound);
	        JugPuzzleView view0 = new JugPuzzleView();
	        jugPuzzle.addObserver(view0);
	        //add buttons to frame.
	        frame.add(moves);
	        frame.add(quit);
	        frame.add(restart);
			frame.pack();
			frame.setSize(370,270);
			frame.setResizable(false);
			frame.setVisible(true);
		}
}

