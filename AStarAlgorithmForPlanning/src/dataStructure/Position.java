package dataStructure;

public class Position 
{

	private double x;
	
	
	private double y;
	
	public Position(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	

	protected double getX() 
	{
		return x;
	}


	protected void setX(double x) 
	{
		this.x = x;
	}


	protected double getY() 
	{
		return y;
	}


	protected void setY(double y)
	{
		this.y = y;
	}

	
	@Override
	public String toString() 
	{
		return "Possition [x=" + x + ", y=" + y + "]";
	}

}
