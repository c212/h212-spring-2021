import javax.swing.JComponent; 
import java.awt.Graphics; 
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class Example extends JComponent implements MouseMotionListener {
  public Example() {
    this.addMouseMotionListener( this );  
  }
  public void mouseMoved(MouseEvent e) { } 
  public void mouseDragged(MouseEvent e) { 
    int x = e.getX(), y = e.getY(); 
    this.x2 = x; 
    this.y2 = y; 
    this.repaint(); // inversion of control 
    System.out.println( "(" + this.x2 + ", " + this.y2 + ")" ); 

  } 
  
  int x1 = 310, y1 = 520, x2 = 220, y2 = 40; 
  
  public void paintComponent(Graphics g) {
    int x1 = 10, y1 = 20; 
    int x2 = 80, y2 = 160; 
    Utilities.arrow(g, x1, y1, x2, y2, 20, 10); 
    Utilities.arrow(g, this.x1, this.y1, this.x2, this.y2, 30, 5); // Stephen 
    
  }
}