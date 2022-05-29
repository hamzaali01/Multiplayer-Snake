package snake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Snake
{
    private static Snake snake;
    private int x,y, dx, dy;
    private char direction= 'R';
    private  ArrayList<Integer> xturns = new ArrayList<>();
    private  ArrayList<Integer> yturns = new ArrayList<>();
    private  ArrayList<Character> directions = new ArrayList<>();
    private static int snakeInstanceCount = 0;
    private int type;
    private boolean CanMove=true;

	public Snake(int x, int y)
	{
	this.x = x;
    this.y = y;	
    dx = 8;
    dy = 0;
    if(snakeInstanceCount==1)
    type = 1;
    else if(snakeInstanceCount==2)
    type = 2;
    else
    type = 3;
	}
	
        
    public static Snake getInstance( int x, int y){
            if(snake==null){
                snakeInstanceCount++;
                return new Snake(x,y);
            }
            else if(snake!=null && snakeInstanceCount==1){
                snakeInstanceCount++;
                return new Snake(x,y);
            }
            else if(snake!=null && snakeInstanceCount==2){
                snakeInstanceCount++;
                return new Snake(x,y);
            }  
            else 
            return snake;

    }

	public void move()
	{
		this.x += dx;
		this.y += dy;
        //resetting the player position if he goes beyond screen limit
        if(x<5)
        x=1000;
        else if(x>1000)
        x=8;
        else if(y<5)
        y=632;
        else if(y>631)
        y=8; 
        CanMove=true;

       // System.out.println(this.x);
	}
	
	public void keyPressed(KeyEvent e) 
	{
        int key = e.getKeyCode();
        //add these empty if conditions for snake2 and 3 if  want to
        if(direction=='R' && key ==KeyEvent.VK_RIGHT || direction=='L' && key ==KeyEvent.VK_LEFT || direction=='U' && key ==KeyEvent.VK_UP || direction=='D' && key ==KeyEvent.VK_DOWN){

        }
        else{
        if(type==1  && CanMove==true){
        if (key == KeyEvent.VK_LEFT && direction!='R') {
            dx = -8;
            dy=0;
            direction = 'L';
        }

        else if (key == KeyEvent.VK_RIGHT && direction!='L') {
            dx = 8;
            dy=0;
            direction = 'R';
        }

        else if (key == KeyEvent.VK_UP && direction!='D') {
            dy = -8;
            dx=0;
            direction = 'U';
        }

        else if (key == KeyEvent.VK_DOWN && direction!='U') {
            dy = 8;
            dx=0;
            direction = 'D';
        }
        xturns.add(this.x);
        yturns.add(this.y);
        directions.add(this.direction);
    }
    else if(type==2  && CanMove==true){
        if (key == KeyEvent.VK_A && direction!='R') {
            dx = -8;
            dy=0;
            direction = 'L';
        }

        else if (key == KeyEvent.VK_D && direction!='L') {
            dx = 8;
            dy=0;
            direction = 'R';
        }

        else if (key == KeyEvent.VK_W && direction!='D') {
            dy = -8;
            dx=0;
            direction = 'U';
        }

        else if (key == KeyEvent.VK_S && direction!='U') {
            dy = 8;
            dx=0;
            direction = 'D';
        }
        xturns.add(this.x);
        yturns.add(this.y);
        directions.add(this.direction);
    } 
    else if(type==3 && CanMove==true){
        if (key == KeyEvent.VK_H && direction!='R') {
            dx = -8;
            dy=0;
            direction = 'L';
        }

        else if (key == KeyEvent.VK_K && direction!='L') {
            dx = 8;
            dy=0;
            direction = 'R';
        }

        else if (key == KeyEvent.VK_U && direction!='D') {
            dy = -8;
            dx=0;
            direction = 'U';
        }

        else if (key == KeyEvent.VK_J && direction!='U') {
            dy = 8;
            dx=0;
            direction = 'D';
        }
        xturns.add(this.x);
        yturns.add(this.y);
        directions.add(this.direction);
    }
    CanMove=false;
    }
    }


    public void paintComponent(Graphics2D g) 
	{
        if(type==1)
		g.setColor(Color.GREEN);
        else if(type==2)
        g.setColor(Color.ORANGE);
        else 
        g.setColor(Color.MAGENTA);

		g.fillRect(x, y, 25, 25);	
	}

    public int getX(){
    return x;
    }
    public int getY(){
        return y;
    }
    public char getNextDirection(){
    return direction;
    }
    public ArrayList<Integer> getTurnXList(){
     if(xturns!=null)
     return xturns;
     else
     return null;
    }
    public ArrayList<Integer> getTurnYList(){
        if(yturns!=null)
        return yturns;
        else
        return null;
       }
    public ArrayList<Character> getdirectionList(){
           if(directions!=null)
        return directions;
        else 
        return null;
       }
    public Rectangle getBounds() {
	    return new Rectangle(x, y, 25, 25);
	}

    public boolean eat(Food food){
    Rectangle r1 = getBounds();
    if(food!=null && r1.intersects(food.getBounds())==true){
        return true;
    }
    else
    return false;
    }
    public int getType(){
        return type;
    }
    
}

