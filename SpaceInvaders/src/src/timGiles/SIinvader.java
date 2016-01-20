package src.timGiles;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class SIinvader extends SIship {
	protected int pointsWorth;
	protected Image imageOne;
	protected Image imageTwo;
	public void setPoints(int x)
	{
		this.pointsWorth = x;
	}
	protected Image getImage(String filename){
		URL url = getClass().getResource(filename);
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}
	protected AudioClip getSound(String filename)
	{	URL url = getClass().getResource(filename);
		return Applet.newAudioClip(url);
	}
	public boolean hasBeenHit(int x, int y) {
		
		/*System.out.println("passed in x "+x);
		System.out.println("passed in y "+y);
		System.out.println("this x "+this.x);
		System.out.println("this y "+this.y);
		System.out.println("this x + width "+this.x+this.width);
		System.out.println("this y + height "+this.y+this.height);*/
		if ((x >= this.x) && (x <= (this.x+this.width))) {
         
            if ((y >= this.y) && (y <= (this.y+this.height))) {
        
                isHit = true;
                return true;
            }
        } 
		return false;
	}
	public SImissle shootSound()
	{
		//shootClip.play();
		SImissle missile = new SImissle(this.x, this.y+12);
		return missile;
		
	}
	public void altImage()
	{
		if(image.equals(imageOne))
		{
			image = imageTwo;
		}
		else
		{
			image = imageOne;
		}
	}
	@Override
	public void moveRight()
	{
		this.x = this.x+5;
	}
	@Override
	public void moveLeft()
	{
		this.x = this.x-5;
	}
	@Override
	public boolean moveDownCheck()
	{
		if(!(this.y+12> 404))
		{
			return true;
			
		}
		return false;
	}
}
