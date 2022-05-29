package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Rectangle;


import java.util.ArrayList;

public class Board extends JPanel implements ActionListener
{
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private final int DELAY = 0;
    private int w = 1024;
    private int h = 680;//768;	
    private Timer timer;
    private int Foodcount = 0;
    private int BigFoodCount = 0;
    JLabel scorelabel = new JLabel("Score = 0");
    public static JLabel scorelabel2 = new JLabel("Score = 0");
    public static JLabel scorelabel3 = new JLabel("Score = 0");
    JLabel gamelabel = new JLabel("All Players Lost!");
    JLabel winLabel1 = new JLabel("Player 1 Won!");
    JLabel winLabel2 = new JLabel("Player 2 Won!");
    JLabel winLabel3 = new JLabel("Player 3 Won!");
    public int score=0;
    public int score2=0;
    public int score3=0;
    public static final Color BLACK  = new Color(0,0,0);

    private Snake snake;
    private Snake snake2;
    private Snake snake3;
    private static ArrayList<Tail> tailList;
    private static ArrayList<Tail> tailList2;
    private static ArrayList<Tail> tailList3;
    Food food;
    BigFood bigfood;
    public static boolean inGame;
    public static boolean drawSnake1=false;
    public static boolean drawSnake2=false;
    public static boolean drawSnake3=false;
    public static boolean SinglePlayer = false;
    private Menu menu;
       
    public Board() 
    {    	
        initBoard();
    }
    
    private void initBoard() //Initializes all the game objects
    {	
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        add(scorelabel);
        add(scorelabel2);
        add(scorelabel3);
        add(gamelabel);
        add(winLabel1);
        add(winLabel2);
        add(winLabel3);

        gamelabel.setVisible(false);
        winLabel1.setVisible(false);
        winLabel2.setVisible(false);
        winLabel3.setVisible(false);

        snake = Snake.getInstance(160, 160);
        snake2 = Snake.getInstance(264, 264);
        snake3 = Snake.getInstance(464, 464);
        tailList = Tail.tailList;
        tailList2 = Tail.tailList2;
        tailList3 = Tail.tailList3;
        tailList.add(new Tail(snake));
        tailList.add(new Tail(snake));
        tailList.add(new Tail(snake));
        tailList2.add(new Tail(snake2));
        tailList2.add(new Tail(snake2));
        tailList2.add(new Tail(snake2));
        tailList3.add(new Tail(snake3));
        tailList3.add(new Tail(snake3));
        tailList3.add(new Tail(snake3));
        
        food = new Food();
        bigfood = null;

        inGame = false;
        menu = new Menu();
	
        setPreferredSize(new Dimension((int)w, (int)h));   //Set the size of Window     
        timer = new Timer(DELAY, this); //Timer with 10 ms delay 
        timer.start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) //Draws all the components on screen
    {
    	g.setColor(getBackground());		//get the background color
        g.clearRect(0 , 0, (int)w, (int)h);	//clear the entire window
    	Dimension size = getSize();  //get the current window size  	
        w = (int)size.getWidth();
        h = (int)size.getHeight();
        
        g.setColor(BLACK);
        g.fillRect(0, 0, w, h);
        scorelabel.setForeground(Color.GREEN);
        scorelabel2.setForeground(Color.ORANGE);
        scorelabel3.setForeground(Color.MAGENTA);
        scorelabel.setBounds(350,0,115,25);
        scorelabel2.setBounds(500,0,115,25);
        scorelabel3.setBounds(650, 0, 115, 25);
        gamelabel.setForeground(Color.RED);
        gamelabel.setBounds(475,0,115,250);
        winLabel1.setForeground(Color.GREEN);
        winLabel1.setBounds(475,0,115,250);
        winLabel2.setForeground(Color.ORANGE);
        winLabel2.setBounds(475,0,115,250);
        winLabel3.setForeground(Color.MAGENTA);
        winLabel3.setBounds(475,0,115,250);
        
        if(inGame==true){
        Graphics2D g2d = (Graphics2D) g;
        if(drawSnake1==true)
        snake.paintComponent(g2d);
        if(drawSnake2==true)
        snake2.paintComponent(g2d);
        if(drawSnake3==true)
        snake3.paintComponent(g2d);
        DrawTails(g2d);
        food.paintComponent(g2d);
        if(bigfood!=null)
        bigfood.paintComponent(g2d);
        }
       
     
        Toolkit.getDefaultToolkit().sync();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        step();
        if(inGame==true){
        Foodcount++;
        BigFoodCount++;
        }
    }
    public void step(){
      if(inGame==true){
        if(Foodcount>400){
           food = new Food();
            Foodcount=0;
        }
        if(BigFoodCount>1500){
          bigfood = new BigFood();
          BigFoodCount=0;
        }
        if(BigFoodCount>400){
            bigfood = null;
        }
        // add another if condition for when food is created on snake tail
     snake.move();
     snake2.move();
     snake3.move();
     TailsMove();
     TailsTurn();
     if(drawSnake1==true){
      if(snake.eat(food)==true || snake.eat(bigfood)==true){
        ArrayList<Tail> tails = Tail.tailList;
         Tail newtail = new Tail(snake);
         newtail.setInstructionCount(tails.get(tails.size()-1).getInstructionCount()); //to make sure the new tail doesnt start following instruction turns from the beginning of the game
         Tail.tailList.add(newtail);
         if(snake.eat(bigfood)==true){
         score+=50;
         bigfood=null;
         }
         else{
         score+=20;
         food = new Food();
         Foodcount=0;
         }
         scorelabel.setText("Score = " + score);
     }
    }
    if(drawSnake2==true){
     if(snake2.eat(food)==true || snake2.eat(bigfood)==true){
        ArrayList<Tail> tails2 = Tail.tailList2;
         Tail newtail = new Tail(snake2);
         newtail.setInstructionCount(tails2.get(tails2.size()-1).getInstructionCount()); //to make sure the new tail doesnt start following instruction turns from the beginning of the game
         Tail.tailList2.add(newtail);
         if(snake2.eat(bigfood)==true){
         score2+=50;
         bigfood=null;
         }
         else{
         score2+=20;
         food = new Food();
         Foodcount=0;
         }
         scorelabel2.setText("Score = " + score2);
     }
    }
    if(drawSnake3==true){
        if(snake3.eat(food)==true || snake3.eat(bigfood)==true){
           ArrayList<Tail> tails3 = Tail.tailList3;
            Tail newtail = new Tail(snake3);
            newtail.setInstructionCount(tails3.get(tails3.size()-1).getInstructionCount()); //to make sure the new tail doesnt start following instruction turns from the beginning of the game
            Tail.tailList3.add(newtail);
            if(snake3.eat(bigfood)==true){
            score3+=50;
            bigfood=null;
            }
            else{
            score3+=20;
            food = new Food();
            Foodcount=0;
            }
            scorelabel3.setText("Score = " + score3);
        }
       }
     if(score>=300 && SinglePlayer==false){
         inGame=false;
         winLabel1.setVisible(true);
     }
     if(score2>=300){
         inGame=false;
         winLabel2.setVisible(true);
     }
     if(score3>=300){
        inGame=false;
        winLabel3.setVisible(true);
    }
     if(drawSnake1==false && drawSnake2==false && drawSnake3==false){
         inGame=false;
         gamelabel.setVisible(true);
     }
     checkCollision();
     repaint();
    }

    }
    private class TAdapter extends KeyAdapter 
    {

        @Override
        public void keyReleased(KeyEvent e) 
        {
           // snake2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN )
            snake.keyPressed(e);
            else if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_S )
            snake2.keyPressed(e);
            else
            snake3.keyPressed(e);
        }
    }
    

    public void checkCollision(){
        ArrayList<Tail> tails = Tail.tailList;
        ArrayList<Tail> tails2 = Tail.tailList2;
        ArrayList<Tail> tails3 = Tail.tailList3;
        for(int i=0; i<tails.size();i++){  
         if(tails.get(i).death()==true){
            drawSnake1=false;
         }
         if(drawSnake1==true && tails.get(i).death(snake2)==true){
            drawSnake2=false;  
         }
         if(drawSnake1==true && tails.get(i).death(snake3)==true){
            drawSnake3 = false;
         }
         }
        for(int i=0; i<tails2.size();i++){  
         if(tails2.get(i).death()==true ){
            drawSnake2=false;
         }
         if(drawSnake2==true && tails2.get(i).death(snake)==true){
            drawSnake1=false;
         }
         if(drawSnake2==true && tails2.get(i).death(snake3)==true){
             drawSnake3=false;
         }
        }
         for(int i=0; i<tails3.size();i++){  
            if(tails3.get(i).death()==true ){
               drawSnake3=false;
            }
            if(drawSnake3==true && tails3.get(i).death(snake)==true){
                drawSnake1=false;
            }
            if(drawSnake3==true && tails3.get(i).death(snake2)==true){
                drawSnake2 = false;
            }
            } 

         Rectangle snake1rect = new Rectangle(snake.getX()+7,snake.getY()+5,20,20);
         Rectangle snake2rect = new Rectangle(snake2.getX()+7,snake2.getY()+5,20,20);
         Rectangle snake3rect = new Rectangle(snake3.getX()+7,snake3.getY()+5,20,20);
         if(drawSnake1==true && drawSnake2 == true && snake1rect.intersects(snake2rect)){
            drawSnake1=false;
            drawSnake2=false;
         }
         if(drawSnake1==true && drawSnake3 == true && snake1rect.intersects(snake3rect)){
            drawSnake1=false;
            drawSnake3=false;
         }
         if(drawSnake2==true && drawSnake3 == true && snake2rect.intersects(snake3rect)){
            drawSnake2=false;
            drawSnake3=false;
         }
    } 
    
    public void DrawTails(Graphics g){
        ArrayList<Tail> tails = Tail.tailList;
        ArrayList<Tail> tails2 = Tail.tailList2;
        ArrayList<Tail> tails3 = Tail.tailList3;
        Graphics2D g2d = (Graphics2D) g;
    if(drawSnake1==true){
       for(int i=0; i<tails.size();i++){  
       tails.get(i).paintComponent(g2d);
       }
    }
    if(drawSnake2==true){
       for(int i=0; i<tails2.size();i++){  
        tails2.get(i).paintComponent(g2d);
        }
    }
    if(drawSnake3==true){
        for(int i=0; i<tails3.size();i++){  
         tails3.get(i).paintComponent(g2d);
         }
     }
    }
    
    public void TailsMove(){
         ArrayList<Tail> tails = Tail.tailList;
         ArrayList<Tail> tails2 = Tail.tailList2;
         ArrayList<Tail> tails3 = Tail.tailList3;
          for(int i=0; i<tails.size();i++){  
           tails.get(i).move();
         }
         for(int i=0; i<tails2.size();i++){  
            tails2.get(i).move();
          }
          for(int i=0; i<tails3.size();i++){  
            tails3.get(i).move();
          }
    }
    public void TailsTurn(){
        ArrayList<Tail> tails = Tail.tailList;
        ArrayList<Tail> tails2 = Tail.tailList2;
        ArrayList<Tail> tails3 = Tail.tailList3;
        for(int i=0; i<tails.size();i++){  
         tails.get(i).Turn();
     }  
     for(int i=0; i<tails2.size();i++){  
        tails2.get(i).Turn();
    } 
    for(int i=0; i<tails3.size();i++){  
        tails3.get(i).Turn();
    } 
    } 
}