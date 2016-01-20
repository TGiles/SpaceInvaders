package src.timGiles;

import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class SIbase extends SIship {

	private AudioClip shootClip;
	private Image alive;
	private Image beenHit;
	
	public SIbase()
	{
		this.x = 250;
		this.y = 380;
		image = getImage("SIbase.gif");
		shootClip = getSound("SIbaseShoot.wav");
		setAlive(getImage("SIbaseBlast.gif"));
	}
	public SImissle shootSound()
	{
		//TODO remember to uncomment shootClip.play();
		shootClip.play();
		SImissle missile = new SImissle(this.x, this.y-12);
		return missile;
		
	}
	public Image getAlive() {
		return alive;
	}
	public void setAlive(Image alive) {
		this.alive = alive;
	}
	@Override
	public boolean hasBeenHit(int x, int y) {
		
		
		if ((x >= this.x) && (x <= (this.x+this.width))) {
         
            if ((y >= this.y-12) && (y <= (this.y+this.height))) {
        
                isHit = true;
                return true;
            }
        } 
		return false;
	}
	
}
