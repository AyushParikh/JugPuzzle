package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class JugPuzzleGUIControllerActionListener implements ActionListener {

	private JugPuzzlePanel jug;

	/*
	 * The actionlistener will tell us which panel is being called from the JugPuzzlePanel.
	 */
	JugPuzzleGUIControllerActionListener(JugPuzzlePanel jug){
		this.jug = jug;
	}
	/*
	 * The actionPerformed will determine what the buttons on the GUIController will do.
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand ().equals ("restart")) {
			JugPuzzleGUIController.jugPuzzle.restart();
			JugPuzzleGUIController.count[0]=null;
			JugPuzzleGUIController.count[1]=null;
		}
		else if (e.getActionCommand ().equals ("quit")) {
			JugPuzzleGUIController.frame.dispose();
			JOptionPane.showMessageDialog (null, "Hope you had fun!"
	                + " ", ":)", JOptionPane.PLAIN_MESSAGE);
		}
		else if (JugPuzzleGUIController.count[0]==null){
			JugPuzzleGUIController.count[0]=jug.jugbutton.getText().substring(4,5);
			JugPuzzleGUIController.moves.setText("Moves: " + Integer.toString(JugPuzzleGUIController.jugPuzzle.getMoves()) + "\nSelect a Jug to Spill INTO\nHighscore: " + JugPuzzleGUIController.highscore);
		}
		else {
		JugPuzzleGUIController.count[1]=jug.jugbutton.getText().substring(4,5);
		JugPuzzleGUIController.jugPuzzle.move(Integer.parseInt(JugPuzzleGUIController.count[0]), Integer.parseInt(JugPuzzleGUIController.count[1]));
		JugPuzzleGUIController.count[0]=null;
		JugPuzzleGUIController.count[1]=null;
		}
		
		
	}
}
