import java.awt.*;
import javax.swing.*;
import java.util.*;
public class StillClock extends JPanel{
private int hour;
private int minute;
private int second;
public StillClock()
{
	setCurrentTime();
}
public StillClock(int hour,int minute,int second)
{
	this.hour=hour;
	this.minute=minute;
	this.second=second;
}
public void setCurrentTime()
{
 Calendar c1=new GregorianCalendar();
 this.hour=c1.get(Calendar.HOUR_OF_DAY);
 this.minute=c1.get(Calendar.MINUTE);
 this.second=c1.getMaximum(Calendar.SECOND);
}
public int getHour()
{
	return hour;
}
public void setHour(int hour)
{
	this.hour=hour;
}
public int getMinute()
{
  return minute;
}
public void setMinute(int minute)
{
	this.minute=minute;
}
public int getSecond()
{
	return second;
}
public void setSecond(int second)
{
	this.second=second;
	repaint();
}
protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
	int clockRadius=60;
	//get the length of pointer of clock;
	int xCenter=getWidth()/2;
	int yCenter=getHeight()/2;
	//locate the centre location.
	g.setColor(Color.BLACK);//set current q of painter
	//draw a circle
	g.drawOval(xCenter-2*clockRadius,yCenter-2*clockRadius,4*clockRadius,4*clockRadius);
	g.drawString("12", xCenter, yCenter-2*clockRadius+5);
	g.drawString("6", xCenter, yCenter+2*clockRadius-5);
	g.drawString("9", xCenter-2*clockRadius+5, yCenter);
	g.drawString("3", xCenter+2*clockRadius-5, yCenter);
	int sLength=(int)(clockRadius*0.8);
	int mLength=(int)(clockRadius*0.5);
	int hLength=(int)(clockRadius*0.3);
	int xSecond=(int)(xCenter+sLength*Math.sin(second*(2*Math.PI/60)));
	int ySecond=(int)(yCenter-sLength*Math.cos(second*(2*Math.PI/60)));
	g.setColor(Color.red);
	g.drawLine(xCenter, yCenter,xSecond, ySecond);
	int xMinute=(int)(xCenter+mLength*Math.sin(minute*(2*Math.PI/60)));
	int yMinute=(int)(yCenter-mLength*Math.cos(minute*(2*Math.PI/60)));
	g.setColor(Color.blue);
	g.drawLine(xCenter, yCenter, xMinute, yMinute);
	int xHour=(int)(xCenter+hLength*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12)));
    int yHour=(int)(xCenter+hLength*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12)));
    g.setColor(Color.yellow);
    g.drawLine(xCenter,yCenter,xHour,yHour);
}
}
