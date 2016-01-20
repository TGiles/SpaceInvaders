package src.timGiles;

public class SIbottom extends SIinvader {
	
	public SIbottom()
	{
		this.setPoints(10);
		imageOne = getImage("SIbottom0.gif");
		imageTwo = getImage("SIbottom1.gif");
		image = imageOne;
		height = image.getHeight(null);
		width = image.getWidth(null);
		
	}
	
}