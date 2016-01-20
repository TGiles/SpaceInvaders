package src.timGiles;


public class SImiddle extends SIinvader {
	
	public SImiddle()
	{
		this.setPoints(20);
		imageOne = getImage("SImiddle0.gif");
		imageTwo = getImage("SImiddle1.gif");
		image = imageOne;
		height = image.getHeight(null);
		width = image.getWidth(null);
	}
	
}
