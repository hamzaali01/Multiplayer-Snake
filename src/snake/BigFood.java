package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BigFood extends Food{
    public void paintComponent(Graphics2D g) 
	{
		g.setColor(Color.RED);
		g.fillOval(x, y, 25, 25);//Only to show image bounds, can be removed	
	}
    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }

}