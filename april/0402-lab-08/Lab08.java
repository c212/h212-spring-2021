import java.awt.Graphics; 
import javax.swing.JFrame; 
import javax.swing.JComponent; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.Color;

public class Lab08 extends JComponent implements MouseMotionListener, MouseListener {

  public void mouseMoved(MouseEvent e) { } 
  public void mouseDragged(MouseEvent e) { 
    if (this.current == null) {
      
    } else {
      this.current.moveTo(e.getX(), e.getY());  
      this.repaint(); 
    }
  } 

  public void mouseEntered(MouseEvent e) { } 
  public void mouseExited(MouseEvent e) { } 
  public void mouseClicked(MouseEvent e) { } 
  public void mousePressed(MouseEvent e) { 
    // pick a node 
    // this.current = this.a.next; // always move the 2nd one  
    Node m = a; 
    int x = e.getX(), y = e.getY(); // this is where the mouse was pressed 
    if (a.contains(x, y)) {
      System.out.println( "It's the first: " + a ); 
      this.current = a; 
      return; 
    } else {
      System.out.println("Let's examine the others ... "); 
      for ( m = m.next  ;    m != a // m.not(a) 
                          && m != null ; m = m.next ) {
        System.out.println( m + " (" + x + ", " + y + ") " + m.contains(x, y) ); 
        if (m.contains(x, y)) {
          this.current = m;
          System.out.println( "I found it: " + this.current ); 
         
          return; 
        }
      }
    }
  } 
  public void mouseReleased(MouseEvent e) { 
    this.current = null; 
  } 
  
  Node current; // null in the beginning 
  
  Node a; 
  public Lab08() {
    
    this.addMouseListener(this); 
    this.addMouseMotionListener(this); 
    
    this.a = new Node(1, new Node(2, new Node(3, null))); 
    this.a = this.a.insert(4); 
    Node m = a; // 4 
    Node n = m.next.next; // 2 (after 4, after 1) 
    n.next = new Node(5, n.next); // insert 5 here 
    // so the list now is: 4, 1, 2, 5, 3
    // let's close the circle
    this.a.next.next.next.next.next = a; 
    //   4  1    2     5   3
  }
  public static void main(String[] args) {
    JFrame f = new JFrame("Example");  
    Lab08 penguins = new Lab08(); 
    f.add(penguins); 
    f.setSize(600, 600); 
    f.setVisible(true); 
  }
  public void paintComponent(Graphics g) {
    // System.out.println( a ); 
    Node runner = this.a;
    runner.draw(g); 
    for ( runner = runner.next ; runner != a && runner != null; runner = runner.next ) {
      runner.draw(g);  // loop now handles circularity
    }
    this.a.draw(g, Color.YELLOW); // so we don't have the line cross over 
  }
}
