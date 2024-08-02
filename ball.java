import java.awt.*;
import java.awt.Color;
import java.applet.*; 
/*<applet code=ball width=600 height=600> 
</applet>*/
public class ball extends Applet implements Runnable
{
Thread thread1;
int c1,c2,c3,c4,c5,c6,c7,c8,c9,m;
public void init()
{
setBackground(Color.BLACK); 
c1=77; //current angle
c2=54;
c3=23;
m=23;
c4=35;
c5=10;
c6=90;
c7=180;
c8=270;
c9=300;
thread1=new Thread(this);
thread1.start();
}
public void run(){
while(true)
{
c1+=27; //incrementing current angle for animation
c2+=18;
c3+=10;
m+=10;
c4+=3;
c5+=1;
c6+=1;
c7+=1;
c8+=1;
c9+=1;
repaint();
try{
 Thread.sleep(125);
}
catch(Exception e){
System.out.println("error");
}
}
}
public void paint(Graphics g)
{
Color j=new Color(225,150,50);
Color s=new Color(240,230,140);
Color n=new Color(173,216,230);
Color p=new Color(128,128,128);
circle2(g,400,400,40,5,c1,Color.WHITE,Color.GRAY);
circle2(g,400,400,60,6,c2,Color.WHITE,Color.YELLOW);
circle2(g,400,400,80,7,c3,Color.WHITE,Color.BLUE);
circle2(g,400,400,93,2,m,Color.BLACK,Color.WHITE);
circle2(g,400,400,100,5,c4,Color.WHITE,Color.RED);
circle2(g,400,400,120,9,c5,Color.WHITE,j); //ring planet
circle2(g,400,400,140,8,c6,Color.WHITE,s); //ring planet
circle2(g,400,400,160,8,c7,Color.WHITE,Color.BLUE); //ring planet
circle2(g,400,400,180,6,c8,Color.WHITE,n);
circle2(g,400,400,200,5,c9,Color.WHITE,p);
}
public void circle2(Graphics g,int xorn,int yorn,int rad,int ballrad,int currentangle,Color s,Color v)
{
if(g==null)
{
throw new NullPointerException("graphics object is null");
}
g.setColor(s);
g.drawOval(xorn-rad,yorn-rad,rad*2,rad*2);
g.setColor(Color.YELLOW);
g.fillOval(380,380,40,40);
int ballornx;int ballorny;
ballornx=(int)(xorn+rad*Math.cos(currentangle*Math.PI/180)); //findnd x and y coordinate
ballorny =(int)(yorn+rad*Math.sin(currentangle*Math.PI/180));
int x=ballornx-ballrad; //adjusting planet position
int y=ballorny-ballrad;
int d=ballrad*2;
if(rad==140){
g.setColor(Color.ORANGE);
g.fillOval(x,y,d,d);
g.setColor(Color.RED);
g.drawOval(x-4,y+4,25,7);
}else if(rad==120){
g.setColor(v);
g.drawOval(x,y,d,d);
g.fillOval(x,y,d,d);
g.setColor(Color.WHITE);
g.drawOval(x-4,y+4,25,7);
}else if(rad==160){
g.setColor(v);
g.drawOval(x,y,d,d);
g.fillOval(x,y,d,d);
g.setColor(Color.WHITE);
g.drawOval(x-4,y+4,25,7);
}
else if(rad==80){
g.setColor(v);
g.drawOval(x,y,d,d);
g.fillOval(x,y,d,d);
g.setColor(Color.GREEN);
g.fillOval(x+3,y+1,12,4);
g.fillOval(x+4,y+12,9,3);
g.fillOval(x,y+7,18,4);
}else
{
g.setColor(v);
g.drawOval(x,y,d,d);
g.fillOval(x,y,d,d);
}
}
}