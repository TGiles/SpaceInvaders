package src.timGiles;

public class SImystery extends SIinvader {
	
	
	SImystery(int x, int y)
	{
		
		pointsWorth = (int) Math.random()+3;
		pointsWorth = pointsWorth *50;
		clip = getSound("SImystery.wav");
		
	
	}
	
	public void playSound()
	{
		clip.play();
	}

}
