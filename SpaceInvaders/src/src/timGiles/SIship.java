package src.timGiles;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;

public class SIship extends SIthing {
	protected boolean isHit = false;
	protected AudioClip clip;
	protected Image image;
	
	public void isHit()
	{
		//image = "hit.gif"
		clip.play();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,x,y,null);
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
	protected int getWidth()
	{
		return this.width;
	}
	protected void setWidth(Image image)
	{
		this.width = image.getWidth(null);
	}
	protected int getHeight()
	{
		return this.height;
	}
	protected void setHeight(Image image)
	{
		this.height = image.getHeight(null);
	}
	@Override
	public boolean hasBeenHit(int x, int y) {
		
		
		if ((x >= this.x) && (x <= (this.x+this.width))) {
         
            if ((y >= this.y) && (y <= (this.y+this.height))) {
        
                isHit = true;
                return true;
            }
        } 
		return false;
	}
}
