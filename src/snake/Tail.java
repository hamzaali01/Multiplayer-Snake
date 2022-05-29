package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Tail
{
    Snake snake;
    int x,y, dx, dy;
    public static ArrayList<Tail> tailList = new ArrayList<>();
    public static ArrayList<Tail> tailList2 = new ArrayList<>();
    public static ArrayList<Tail> tailList3 = new ArrayList<>();
    public  ArrayList<Integer> xturns = new ArrayList<>();
    public  ArrayList<Integer> yturns = new ArrayList<>();
    public  ArrayList<Character> directions = new ArrayList<>();
    char direction;
    int next = 0; // represents the index number of instruction in the instructionList it is going to execute 
	
    public Tail(Snake snake)
	{
    this.snake = snake;
    getNextTail();
	}
	
	
	public void move()
	{
            if(direction=='R'){
                this.x += 8;
                this.y += 0;
            }
            if(direction=='L'){
                this.x += -8;
                this.y += 0;
            }
            if(direction=='U'){
                this.x += 0;
                this.y += -8;
            }
            if(direction=='D'){
                this.x += 0;
                this.y += 8;
            }
        //resetting the player position if he goes beyond screen limit
        if(x<5)
        x=1000;
        else if(x>1000)
        x=8;
        else if(y<5)
        y=632;
        else if(y>631)
        y=8;
        
	}
	
    //intializes the position and direction of new tail
   public void getNextTail(){
       if(snake.getType()==1){
    if(tailList.isEmpty()==true){
        if(snake.getNextDirection()=='R'){
        this.x = snake.getX()-32;
        this.y = snake.getY();
        this.direction= snake.getNextDirection();
        }
        if(snake.getNextDirection()=='L'){
            this.x = snake.getX()+32;
            this.y = snake.getY();
            this.direction= snake.getNextDirection();
            }
            if(snake.getNextDirection()=='U'){
                this.x = snake.getX();
                this.y = snake.getY()+32;
                this.direction= snake.getNextDirection();
                }
                if(snake.getNextDirection()=='D'){
                    this.x = snake.getX();
                    this.y = snake.getY()-32;
                    this.direction= snake.getNextDirection();
                    }
    }
    else{
        this.direction = tailList.get(tailList.size()-1).direction;
        if(direction=='R'){
            this.x =  tailList.get(tailList.size()-1).x-32;
            this.y = tailList.get(tailList.size()-1).y;
            }
            if(tailList.get(tailList.size()-1).direction=='L'){
                this.x = tailList.get(tailList.size()-1).x+32;
                this.y = tailList.get(tailList.size()-1).y;
                }
                if(tailList.get(tailList.size()-1).direction=='U'){
                    this.x = tailList.get(tailList.size()-1).x;
                    this.y = tailList.get(tailList.size()-1).y+32;;
                    }
                    if(tailList.get(tailList.size()-1).direction=='D'){
                        this.x = tailList.get(tailList.size()-1).x;
                        this.y = tailList.get(tailList.size()-1).y-32;
                        }
                        this.direction = tailList.get(tailList.size()-1).direction;
        }
    }
    else if(snake.getType()==2){
        if(tailList2.isEmpty()==true){
            if(snake.getNextDirection()=='R'){
            this.x = snake.getX()-32;
            this.y = snake.getY();
            this.direction= snake.getNextDirection();
            }
            if(snake.getNextDirection()=='L'){
                this.x = snake.getX()+32;
                this.y = snake.getY();
                this.direction= snake.getNextDirection();
                }
                if(snake.getNextDirection()=='U'){
                    this.x = snake.getX();
                    this.y = snake.getY()+32;
                    this.direction= snake.getNextDirection();
                    }
                    if(snake.getNextDirection()=='D'){
                        this.x = snake.getX();
                        this.y = snake.getY()-32;
                        this.direction= snake.getNextDirection();
                        }
        }
        else{
            this.direction = tailList2.get(tailList2.size()-1).direction;
            if(direction=='R'){
                this.x =  tailList2.get(tailList2.size()-1).x-32;
                this.y = tailList2.get(tailList2.size()-1).y;
                }
                if(tailList2.get(tailList2.size()-1).direction=='L'){
                    this.x = tailList2.get(tailList2.size()-1).x+32;
                    this.y = tailList2.get(tailList2.size()-1).y;
                    }
                    if(tailList2.get(tailList2.size()-1).direction=='U'){
                        this.x = tailList2.get(tailList2.size()-1).x;
                        this.y = tailList2.get(tailList2.size()-1).y+32;;
                        }
                        if(tailList2.get(tailList2.size()-1).direction=='D'){
                            this.x = tailList2.get(tailList2.size()-1).x;
                            this.y = tailList2.get(tailList2.size()-1).y-32;
                            }
                            this.direction = tailList2.get(tailList2.size()-1).direction;
            }
        } 
        else{ 
                if(tailList3.isEmpty()==true){
            if(snake.getNextDirection()=='R'){
            this.x = snake.getX()-32;
            this.y = snake.getY();
            this.direction= snake.getNextDirection();
            }
            if(snake.getNextDirection()=='L'){
                this.x = snake.getX()+32;
                this.y = snake.getY();
                this.direction= snake.getNextDirection();
                }
                if(snake.getNextDirection()=='U'){
                    this.x = snake.getX();
                    this.y = snake.getY()+32;
                    this.direction= snake.getNextDirection();
                    }
                    if(snake.getNextDirection()=='D'){
                        this.x = snake.getX();
                        this.y = snake.getY()-32;
                        this.direction= snake.getNextDirection();
                        }
        }
        else{
            this.direction = tailList3.get(tailList3.size()-1).direction;
            if(direction=='R'){
                this.x =  tailList3.get(tailList3.size()-1).x-32;
                this.y = tailList3.get(tailList3.size()-1).y;
                }
                if(tailList3.get(tailList3.size()-1).direction=='L'){
                    this.x = tailList3.get(tailList3.size()-1).x+32;
                    this.y = tailList3.get(tailList3.size()-1).y;
                    }
                    if(tailList3.get(tailList3.size()-1).direction=='U'){
                        this.x = tailList3.get(tailList3.size()-1).x;
                        this.y = tailList3.get(tailList3.size()-1).y+32;;
                        }
                        if(tailList3.get(tailList3.size()-1).direction=='D'){
                            this.x = tailList3.get(tailList3.size()-1).x;
                            this.y = tailList3.get(tailList3.size()-1).y-32;
                            }
                            this.direction = tailList3.get(tailList3.size()-1).direction;
            }
        }
    }

    public void paintComponent(Graphics2D g) 
	{
        if(snake.getType()==1){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 25, 25);
        }
        else if(snake.getType()==2){
            g.setColor(Color.ORANGE);
            g.fillRect(x,y,25,25);
        }
        else{
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, 25, 25);
        }	
       // g.setColor(Color.RED);
       // g.drawRect(x+13,y+13,3,3);
       /// g.drawRect(snake.getX()+7,snake.getY()+5,20,20);

       //g.setColor(Color.MAGENTA);
       //g.drawRect(5, 5, 1000, 635);
	}

    public void Turn(){
        xturns = snake.getTurnXList();
        yturns = snake.getTurnYList();
        directions = snake.getdirectionList();
        if(next<xturns.size() && this.x==xturns.get(next) && this.y==yturns.get(next)){
            //if(direction=='R' && this.x>=xturns.get(next)  || direction=='L' && this.x<=xturns.get(next) || direction=='U' && this.y<=yturns.get(next) || direction=='D' && this.y>=yturns.get(next) ){
            this.x = xturns.get(next);
            this.y = yturns.get(next);
            this.direction = snake.getdirectionList().get(next);
            next++;
          //  }
        }
    }

public void setInstructionCount(int val){
next=val;
}
public int getInstructionCount(){
return next;
}
public Rectangle getBounds() {
    return new Rectangle(x, y, 25, 25);
}
public boolean death(){
    Rectangle r1 = new Rectangle(x+13,y+13,3,3);
    Rectangle r2 = new Rectangle(snake.getX()+10,snake.getY()+10,10,10);
    if(r2.intersects(r1)){//r2.contains(r1)==true){
     return true;
    }
    else
    return false; 
}
public boolean death(Snake snake2){
    Rectangle r1 = new Rectangle(x+13,y+13,5,5);
    Rectangle r2 = new Rectangle(snake2.getX()+13,snake2.getY()+7,15,15);
    if(r2.intersects(r1)==true){
     return true;
    }
    else
    return false; 
}
}

