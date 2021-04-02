import java.awt.Graphics;
import java.awt.Color; 

public class Node {
  public void moveTo(int x, int y) {
    this.x = x; 
    this.y = y; 
  }
  public boolean contains(int x, int y) {
    int dx = this.x - x, dy = this.y - y; 
    return Math.sqrt(dx * dx + dy * dy) < 30; 
  }
  public boolean not(Node other) {
    return this.x != other.x || this.y != other.y; 
  }
  int x, y; // center 
  int value; 
  int radius = 15; 
  Node next; 
  public Node(int value, Node next) {
    this.value = value;  
    this.next = next;
    this.x = 100 + (int)(400 * Math.random()); 
    this.y = 100 + (int)(400 * Math.random()); 
  }
  public Node insert(int value) {
    return new Node(value, this); // cons    
  }
  public String toString() {
    // if (this.next == null) return this.value + " ."; 
    // else return this.value + " " + this.next; 
    return "n(" + this.x + ", " + this.y + ")";
  }
  public void draw(Graphics g, Color c) {
    g.setColor(c); 
    g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);  
    g.setColor(Color.BLACK); 
    g.drawString(this.value + "", this.x, this.y); 
    g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);      
  }
  public void draw(Graphics g) {
    
    if (this.next == null) { 
      // do nothing (no link) then show yourself
    } else {
      // g.drawLine(this.x, this.y, this.next.x, this.next.y);      
      // this is drawing the lines 
      Utilities.arrow(g, this.x, this.y, this.next.x, this.next.y, 30, 5); 
      
    } // now draw the node 
    g.setColor(Color.WHITE); 
    g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);  
    g.setColor(Color.BLACK); 
    g.drawString(this.value + "", this.x, this.y); 
    g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);  

  }
}