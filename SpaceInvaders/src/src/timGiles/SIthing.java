package src.timGiles;

import java.awt.Graphics;

public abstract class SIthing {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int getX() {
		return x;
	}
	protected void setX(int x) {
		this.x = x;
	}
	protected int getY() {
		return y;
	}
	protected void setY(int y) {
		this.y = y;
	}
	protected int getWidth() {
		return width;
	}
	protected void setWidth(int width) {
		this.width = width;
	}
	protected int getHeight() {
		return height;
	}
	protected void setHeight(int height) {
		this.height = height;
	}
	
	public abstract void paintComponent(Graphics g);
	public abstract boolean hasBeenHit(int x, int y);
	public void moveRight()
	{
		if(!(this.x+12> 455))
		{
			this.x = this.x+5;
			
		}
		
	}
	public void moveLeft()
	{
		if(!(this.x-12<0))
		{
			this.x = this.x-5;
			
		}
		
		
	}
	public void moveDown()
	{
		if(!(this.y+12 > 400))
		{
			this.y = this.y+12;
			
		}
		
	}
	public void moveUp()
	{
		if(!(this.y-12 < 0))
		{
			this.y = this.y-12;
			
		}
		
	}
	public boolean moveRightCheck()
	{
		if(!(this.x+12> 455))
		{
			return true;
			
		}
		return false;
	}
	public boolean moveLeftCheck()
	{
		if(!(this.x-12< 0))
		{
			return true;
			
		}
		return false;
	}
	public boolean moveUpCheck()
	{
		if(!(this.y-12< 0))
		{
			return true;
			
		}
		return false;
	}
	public boolean moveDownCheck()
	{
		if(!(this.y+12> 400))
		{
			return true;
			
		}
		return false;
	}
	

}
