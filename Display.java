import java.awt.*;
import javax.swing.*;
public class Display extends JFrame{
public Display()
{
   StillClock c1=new StillClock();
   add(c1);
}
public static void main(String[] args)
{
	Display d1=new Display();
	d1.setTitle("sdsds");
	d1.setSize(400,500);
	d1.setLocationRelativeTo(null);
	d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	d1.setVisible(true);
}
}
