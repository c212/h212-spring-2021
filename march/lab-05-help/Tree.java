public class Tree extends Node {
  Tree(int num) {
    super(num);
  }
  Tree(int num, Tree left, Tree right) {
    super(num, left, right);
  }
  public void insert(int num) {
    int coin = (int)(Math.random() * 100); 
    if (coin < 50) {
      if (this.left == null)
        this.left = new Tree(num); 
      else 
        ((Tree)(this.left)).insert(num); 
    } else {
      if (this.right == null)
        this.right = new Tree(num); 
      else 
        ((Tree)(this.right)).insert(num);  
    }
  }
  public static void main(String[] args) {
    Tree a = new Tree(1); 
    // System.out.println("We start with a 1 -------------------"); 
    // a.display(); 
    for (int i = 2; i < 30; i++) {
      a.insert(i);
      // System.out.println("After inserting " + i + " ------------------"); 
      if (i + 1 == 30) a.display();
    }
  }
}
