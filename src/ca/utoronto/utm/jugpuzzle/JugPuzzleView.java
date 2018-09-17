package ca.utoronto.utm.jugpuzzle;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;


public class JugPuzzleView implements Observer {

	/*
	 * This is the VIEW of the MVC. 
	 * It will update the model of the jugpuzzle everytime there has been a change to the game
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jug = (JugPuzzle)o;
		//updates the progressbars and move text when the puzzle is updated.
		JugPuzzleGUIController.jug0.getProgressBar().setValue(jug.getJug(0).getAmount()*100/8);
		JugPuzzleGUIController.jug0.progressBar.setString(Integer.toString(jug.getJug(0).getAmount())+"/8");
		JugPuzzleGUIController.jug1.getProgressBar().setValue(jug.getJug(1).getAmount()*100/5);
		JugPuzzleGUIController.jug1.progressBar.setString(Integer.toString(jug.getJug(1).getAmount())+"/5");
		JugPuzzleGUIController.jug2.getProgressBar().setValue(jug.getJug(2).getAmount()*100/3);
		JugPuzzleGUIController.jug2.progressBar.setString(Integer.toString(jug.getJug(2).getAmount())+"/3");
		JugPuzzleGUIController.moves.setText("Moves: " + Integer.toString(jug.getMoves()) + "\nSelect a Jug to Spill FROM\nHighscore: " + JugPuzzleGUIController.highscore);
		
		//Will disable the buttons when the game is completed. Also will update highscores.
		if (jug.getIsPuzzleSolved()==true) {
			JugPuzzleGUIController.jug0.jugbutton.setEnabled(false);
			JugPuzzleGUIController.jug1.jugbutton.setEnabled(false);
			JugPuzzleGUIController.jug2.jugbutton.setEnabled(false);
			JugPuzzleGUIController.moves.setBackground(Color.BLUE);
			JugPuzzleGUIController.moves.setForeground(Color.RED);
			if (jug.getMoves() < JugPuzzleGUIController.highscore | JugPuzzleGUIController.highscore== 0) {
				JugPuzzleGUIController.highscore = jug.getMoves();
			}
			JugPuzzleGUIController.moves.setText("Congratz! You beat the game in \n"+Integer.toString(jug.getMoves()) + " moves!\nHighscore: "+ JugPuzzleGUIController.highscore);
		}
		else {
			JugPuzzleGUIController.jug0.jugbutton.setEnabled(true);
			JugPuzzleGUIController.jug1.jugbutton.setEnabled(true);
			JugPuzzleGUIController.jug2.jugbutton.setEnabled(true);
			JugPuzzleGUIController.moves.setBackground(Color.WHITE);
			JugPuzzleGUIController.moves.setForeground(Color.BLACK);
			JugPuzzleGUIController.moves.setText("Moves: " + Integer.toString(jug.getMoves()) + "\nSelect a Jug to Spill FROM\nHighscore: " + JugPuzzleGUIController.highscore);
		}
	}
	
}
