import java.util.*; 

public class BST extends SimpleBST {
  BST(int num) {
    super(num);
  }
  BST(int num, BST left, BST right) {
    super(num, left, right);
  }
  public BST delete(int num) {
    BST left = (BST)(this.left), right = (BST)(this.right); 
    if (this.key == num) {
      if (left == null && right == null) return null;  
      else if (left == null) { // return right;
        int root = right.findSmallestLarger(); 
        return new BST(root, left, right.delete(root)); 
      } else if (right == null) { // return left; 
        int root = left.findLargestSmaller();
        return new BST(root, left.delete(root), right); 
      } else {
        int root = left.findLargestSmaller();
        return new BST(root, left.delete(root), right); 
      }
    } else if (this.key > num) {
      if (left != null) {  
        return new BST(this.key, left.delete(num), right); 
      } else return this; 
    } else {
      if (right != null) {  
        return new BST(this.key, left, right.delete(num)); 
      } else return this;  
    }
  }
  public int findLargestSmaller() {
    BST result = this; 
    while (result.right != null)
      result = (BST)(result.right); 
    return result.key;       
  }
  public int findSmallestLarger() {
    BST result = this; 
    while (result.left != null)
      result = (BST)(result.left); 
    return result.key;       
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 
    System.out.print("start> insert "); 
    String line = in.nextLine(); 
    if (line.equals("bye")) {
      return;  
    } else {
      BST a = new BST(Integer.parseInt( line )); 
      a.display(); 
      while (true) { 
        System.out.print("enter> "); 
        line = in.nextLine(); 
        Scanner tokenizer = new Scanner(line); 
        String command = tokenizer.next(); 
        if (command.equals("bye")) break; 
        int num = Integer.parseInt(tokenizer.next()); 
        if (command.equals("insert")) { 
          a.insert(new BST(num)); 
          a.display(); 
        } else if (command.equals("delete")) {
          a = a.delete(num); 
          a.display(); 
        } else {
          System.out.println("I don't understand " + command);  
        }
      }
    }
  }
}
