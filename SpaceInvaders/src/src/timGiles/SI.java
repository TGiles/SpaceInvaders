package src.timGiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class SI extends JFrame {
	private SIPanel panel;
	public SI() {
		super("Space Invaders");

		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.
			 * WindowEvent) Method confirming if a user wants to exit the
			 * program via red X
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SI.this, "Want to exit?");
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				}

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");
		menuBar.add(game);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(help);

		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem pause = new JMenuItem("Pause");
		JMenuItem resume = new JMenuItem("Resume");
		JMenuItem quit = new JMenuItem("Quit");
		JMenuItem about = new JMenuItem("About...");

		game.add(newGame);
		game.addSeparator();
		game.add(pause);
		game.add(resume);
		game.addSeparator();
		game.add(quit);

		help.add(about);
		add( panel = new SIPanel());

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panel.newGame();
			}

		});
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.pause();

			}

		});
		resume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.resume();

			}

		});
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(SI.this, "Want to exit?");
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				}

			}

		});
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Space invaders by Tim Giles");
				panel.about();

			}

		});
		
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(500, 450);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		JFrame f = new SI();
		f.setVisible(true);
	}

}
