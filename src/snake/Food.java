package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Rectangle;

public class Food {
int x;
int y;
Random rand;
    public Food()
	{
    rand= new Random();
    int x = rand.nextInt(1000);
    int y = rand.nextInt(635);
     this.x= x;
     this.y = y;
	} 
   
    public void setX(int x){
     this.x = x;
    }
    public void setY(int y){
       this.y= y;
    }
    public int getX(){
       return x;
    }
    public int getY(){
      return y;
    }


    
    public void paintComponent(Graphics2D g) 
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 16, 16);//Only to show image bounds, can be removed	
	}

  public Rectangle getBounds() {
    return new Rectangle(x, y, 16, 16);
}
}
