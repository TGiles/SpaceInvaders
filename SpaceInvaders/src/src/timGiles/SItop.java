package src.timGiles;

public class SItop extends SIinvader {
	
	public SItop()
	{
		
		this.setPoints(30);
		imageOne = getImage("SItop0.gif");
		imageTwo = getImage("SItop1.gif");
		image = imageOne;
		height = image.getHeight(null);
		width = image.getWidth(null);
	}
	
}
