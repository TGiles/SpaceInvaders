package src.timGiles;

import java.awt.*;

public class SImissle extends SIthing {

	public SImissle(int x, int y)
	{
		setX(x);
		setY(y);
		setWidth(2);
		setHeight(10);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.x+12, this.y, this.width, this.height);
		
		//System.out.println("Missle print" + this.getX() +" " +this.getY());
	}

	@Override
	public boolean hasBeenHit(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void moveUp()
	{
		this.y = this.y-5;
	}
	
}
