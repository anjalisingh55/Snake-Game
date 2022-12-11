import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Fsnake extends JFrame{
        JPsnake jp;
        Fsnake(){
            jp=new JPsnake();
            add(jp);
        }
    
}
class JPsnake extends JPanel implements ActionListener,KeyListener{
    ImageIcon img1,img2,img3;
    Image dot,head,food;
    int x[]=new int[100];
    int y[]=new int[100];
    int dots=5;
    boolean start_game=false;

    boolean left=false,right=false,up=false,down=false;
    int r1=0,r2=0;

    JPsnake(){
        x[0]=90;
        y[0]=60;
        x[1]=75;
        y[1]=60;
        x[2]=60;
        y[2]=60;
        x[3]=45;
        y[3]=60;
        x[4]=30;
        y[4]=60;
    
        setBackground(Color.black);
        img1=new ImageIcon("dot.png");
        dot = img1.getImage();
        img2=new ImageIcon("head.png");
        head = img2.getImage();
        img3=new ImageIcon("food.png");
        food = img3.getImage();

        Timer t = new Timer(200,this);
        t.start();

        addKeyListener(this);
        setFocusable(true);

        randomDemo();
    }

    void randomDemo(){
        r1=(int)Math.round(Math.random()*40+1);
        r1=r1*15;
        r2=(int)Math.round(Math.random()*40+1);
        r2=r2*15;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(food,r1,r2,this);

        for(int i=0;i<dots;i++){
        if(i==0){
            g.drawImage(head,x[i],y[i],this);
        }
        else{
        g.drawImage(dot,x[i],y[i],this);}
        }
    }

    public void actionPerformed(ActionEvent e){

        if(x[0]==r1&&y[0]==r2){
            dots++;
            randomDemo();
        }

        if(start_game){
        for(int i=dots;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        if(right){
        x[0]=x[0]+15;
        }
        if(left){
            x[0]=x[0]-15;
        }
        if(up){
            y[0]=y[0]-15;
        }
        if(down){
            y[0]=y[0]+15;
        }
        
        }
        repaint();
    } 
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        start_game=true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left=true;
            right=false;up=false;down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            right=true;
            left=false;up=false;down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            up=true;
            right=false;left=false;down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down=true;
            right=false;up=false;left=false;
        }
    }
    public void keyTyped(KeyEvent e){}
} 
class snakegame{
    public static void main(String ar[]){
        Fsnake f = new Fsnake();
        f.setVisible(true);
        f.setLocation(100,0);
        f.setSize(700,700);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }
}

