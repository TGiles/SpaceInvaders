package src.timGiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SIPanel extends JPanel implements ActionListener, KeyListener {

	private boolean isPaused = true;
	private boolean isGameOver = true;
	private boolean left = false;
	private boolean right = false;
	private Timer timer;
	private SIbase base;
	private SIinvader invaders[][] = new SIinvader[5][10]; //i then j, so 5 rows and 10 columns
	private SIinvader testInvader;
	private int score = 0;
	private SImissle baseMissle;
	private int count = 0;
	private boolean alienLeft = false;
	private boolean alienRight = true;
	private int countWave = 40;
	private SImissle invaderMissles[] = new SImissle[3];
	private int invaderMax[] = new int[10];
	private int invaderX = 85;
	private int invaderY = 85;
	private SImystery mystery = null;
	private int mysteryDirection;
	public SIPanel() {

		
		

		//testInvader = new SItop();
		createInvaders(invaderX, invaderY);
		setFocusable(true);

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double mysteryChance = Math.random();
				if(mysteryChance>0.997)
				{
				System.out.println(mysteryChance);
				}
				if(mysteryChance>0.997 && mystery == null)
				{
					mysteryDirection = (int) (Math.random()+1);
					if(mysteryDirection==1)
					{
						mystery = new SImystery(0, 65);
					}
					else
					{
						mystery = new SImystery(450,65);
					}
				}
				if(mystery!=null)
				{
					
					if(mysteryDirection==1)
					{
						if(mystery.moveRightCheck())
						{
							mystery.moveRight();
							mystery.playSound();
						}
						else
						{
							mystery = null;
						}
					}
					else
					{
						if(mystery.moveLeftCheck())
						{
							mystery.moveLeft();
							mystery.playSound();
						}
						else
						{
							mystery = null;
						}
					}
				}
				if (left)
					base.moveLeft();
				if (right)
					base.moveRight();
				if (baseMissle != null) {
					if (baseMissle.moveUpCheck()) {
						baseMissle.moveUp();
						int baseMissleX = baseMissle.getX();
						int baseMissleY = baseMissle.getY();
						for (int i = 0; i < invaders.length; i++) {
							for (int j = 0; j < invaders[0].length; j++) {
								if (invaders[i][j] != null) {
									if (invaders[i][j].hasBeenHit(baseMissleX, baseMissleY)) {
										if (invaders[i][j] instanceof SItop) {
											score += 30;
										}
										if (invaders[i][j] instanceof SImiddle) {
											score += 20;
										}
										if (invaders[i][j] instanceof SIbottom) {
											score += 10;
										}
										baseMissle = null;
										invaders[i][j] = null;
									}

								}
							}
						}
					} else {
						baseMissle = null;
					}
				}
				if (countWave == count||countWave==0) {
					
					boolean loopBreak = false;
					if (alienRight) {
						for (int i = invaders.length - 1; i >= 0; i--) {
							for (int j = invaders[0].length - 1; j >= 0; j--) {
								if (invaders[i][j] != null) {

									if (invaders[i][j].moveRightCheck()) {
										invaders[i][j].moveRight();
										invaders[i][j].altImage();

									} else {
										alienRight = false;
										alienLeft = true;
										loopBreak = true;
										for (i = invaders.length - 1; i >= 0; i--) {
											for (j = invaders[0].length - 1; j >= 0; j--) {
												if (invaders[i][j] != null) {
													invaders[i][j].moveDown();

													invaders[i][j].altImage();
												}
											}
										}
										countWave = (int) (countWave * 0.8);
										//System.out.println(countWave);
										break;
									}

								}
								if (loopBreak) {
									break;
								}
							}
						}

					} else if (alienLeft) {
						for (int i = 0; i < invaders.length; i++) {
							for (int j = 0; j < invaders[0].length; j++) {
								if (invaders[i][j] != null) {

									if (invaders[i][j].moveLeftCheck()) {
										invaders[i][j].moveLeft();
										invaders[i][j].altImage();
									} else {
										alienLeft = false;
										alienRight = true;
										loopBreak = true;
										for (i = 0; i < invaders.length; i++) {
											for (j = 0; j < invaders[0].length; j++) {
												if (invaders[i][j] != null) {
													invaders[i][j].moveDown();
													invaders[i][j].altImage();
												}
											}
										}
										countWave = (int) (countWave * 0.8);
										break;
									}
								}

							}
							if (loopBreak) {
								break;
							}
						}

					}
					count = 0;
				}
				count++;

				boolean notNull = false;
				for (SIinvader[] array : invaders) {
					for (SIinvader val : array) {
						if (val != null) {
							notNull = true;
							break;
						}
					}
				}
				if (notNull) {

				} else {
					createInvaders(invaderX, invaderY);
					countWave = 40;
				}
				for (SIinvader[] array : invaders) {
					for (SIinvader val : array) {
						if (val != null) {
							if (base.hasBeenHit(val.getX(), val.getY())) {
								gameOver();
							}
						}
					}
				}
				for(int i = 0; i < invaderMax.length;i++)
				{
					invaderMax[i]=-1;
				}
				//TODO fix this loop to put missles at the front of the row/column whatever.
				
				for (int i = 0; i < invaders.length; i++) {
					for (int j =0; j < invaders[0].length; j++) {
						if (invaders[i][j] != null) {
							if(i>invaderMax[i])
							{
								invaderMax[i]=i;
							}
						}
					
						//System.out.println(invaderMax[j]);
					}
					
				}
			
				
				double shootChance = Math.random() * (10);
				//(int)(Math.random() * (max - min) + min)
				if (shootChance > 8.0) {

					int randomChoice = (int) (Math.random() * 10);

					//System.out.println(randomChoice + " random Choice");
					int invaderMaxCol = invaderMax[randomChoice];
					//System.out.println(invaderMaxCol + " invaderMaxCol");

					if (invaderMissles[0] == null) {
						if (invaderMaxCol!=-1&&invaders[invaderMaxCol][randomChoice] != null) {
							invaderMissles[0] = invaders[invaderMaxCol][randomChoice].shootSound();
						}
					} else if (invaderMissles[1] == null) {
						if (invaderMaxCol!=-1&&invaders[invaderMaxCol][randomChoice] != null) {
							invaderMissles[1] = invaders[invaderMaxCol][randomChoice].shootSound();
						}
					} else if (invaderMissles[2] == null) {
						if (invaderMaxCol!=-1&&invaders[invaderMaxCol][randomChoice] != null) {
							invaderMissles[2] = invaders[invaderMaxCol][randomChoice].shootSound();
						}
					}
				}
				for (int i = 0; i < invaderMissles.length; i++) {

					if (invaderMissles[i] != null) {
						if (base.hasBeenHit(invaderMissles[i].getX(), invaderMissles[i].getY())) {
							gameOver();
						}
						if (count % 2 == 0) {
							invaderMissles[i].moveDown();

							if (invaderMissles[i].moveDownCheck() == false) {
								invaderMissles[i] = null;

							}
						}
					}
				}
				repaint();

			}

		});
		addKeyListener(this);

		setBackground(Color.BLACK);
	}

	public void newGame() {
		score = 0;
		createInvaders(invaderX, invaderY);
		base = new SIbase();
		isGameOver=false;
		timer.start();
		

	}

	public void about() {
		isPaused = true;
		timer.stop();
		

	}

	public void quit() {
		isPaused = true;
		timer.stop();

	}

	public void resume() {
		if(isGameOver)
		{
			return;
		}
		isPaused = false;
		timer.start();

	}

	public void pause() {
		timer.stop();
		isPaused = true;

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			// base.moveLeft();
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			// base.moveRight();
			right = true;
			break;
		case KeyEvent.VK_SPACE:

			if (baseMissle == null) {
				baseMissle = base.shootSound();
				// System.out.println("base missle print out");
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(mystery!=null)
		{
			mystery.paintComponent(g);
		}
		if(base!=null)
		{
		base.paintComponent(g);
		}
		g.setColor(Color.GREEN);
		g.drawString("Score: " + score, 380, 50);
		if(isGameOver)
		{
			g.drawString("GAME OVER", 230, 250);
		}
		// System.out.println(baseMissle);
		if (baseMissle != null) {
			baseMissle.paintComponent(g);
			// System.out.println("base missle print out");
		}
		for (int i = 0; i < invaderMissles.length; i++) {
			if (invaderMissles[i] != null) {
				invaderMissles[i].paintComponent(g);
			}
		}
		for (int i = 0; i < invaders.length; i++) {
			for (int j = 0; j < invaders[0].length; j++) {
				if (invaders[i][j] != null)
					invaders[i][j].paintComponent(g);
			}

			// System.out.println("Are we here?");
		}

	}

	private void createInvaders(int invaderX, int invaderY) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				switch (i) {
				case 0:
					SItop top = new SItop();
					top.setX(invaderX);
					top.setY(invaderY);
					invaders[i][j] = top;
					break;
				case 1:
					SImiddle middle = new SImiddle();
					middle.setX(invaderX);
					middle.setY(invaderY);
					invaders[i][j] = middle;
					break;
				case 2:
					SImiddle middle1 = new SImiddle();
					middle1.setX(invaderX);
					middle1.setY(invaderY);
					invaders[i][j] = middle1;
					break;
				case 3:
					SIbottom bottom = new SIbottom();
					bottom.setX(invaderX);
					bottom.setY(invaderY);
					invaders[i][j] = bottom;
					break;
				case 4:
					SIbottom bottom1 = new SIbottom();
					bottom1.setX(invaderX);
					bottom1.setY(invaderY);
					invaders[i][j] = bottom1;
					break;
				}
				invaderX = invaderX + 35;

			}
			invaderX = 85;
			invaderY = invaderY + 25;
		}
	}
	

	private void gameOver() {
		base.image = base.getAlive();
		timer.stop();
		isGameOver=true;
	}
}
