public class SimpleBST extends Tree {
  SimpleBST(int num) {
    super(num);
  }
  SimpleBST(int num, SimpleBST left, SimpleBST right) {
    super(num, left, right);
  }
  public boolean find(int num) {
    if (this.key == num) return true; 
    else { 
      if (this.key > num) { 
        if (this.left == null) return false;
        else return ((SimpleBST)(this.left)).find(num); 
      } else { 
        if (this.right == null) return false;
        else return ((SimpleBST)(this.right)).find(num); 
      }
    }
  }
  public void insert(SimpleBST tree) {
    int num = tree.key; 
    if (this.key == num) {
      System.out.println(num + " already in."); 
      return; 
    } else if (num < this.key) {
      if (this.left == null) this.left = tree; 
      else ((SimpleBST)(this.left)).insert(tree);
    } else {
      if (this.right == null) this.right = tree; 
      else ((SimpleBST)(this.right)).insert(tree);
    }
  }
  public static void main(String[] args) {
    SimpleBST a = new SimpleBST(5, new SimpleBST(3), new SimpleBST(6)); 
    for (int i = 0; i < 10; i++) { 
      System.out.println( "Is " + i + " in there? Answer: " + a.find(i) ); 
    }
    SimpleBST b = new SimpleBST(50); 
    for (int i = 0; i < 20; i++) {
       b.insert(new SimpleBST((int)(Math.random() * 100 + 1))); 
    }
    b.display(); 
  }
}
