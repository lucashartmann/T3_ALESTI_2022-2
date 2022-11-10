public class App {
  public static void main(String[] args) {
    BinarySearchTree b = new BinarySearchTree();

    b.add(500);
    b.add(212);
    b.add(614);
    b.add(101);
    b.add(230);
    b.add(20);
    b.add(30);

    String dot = b.toDOT();

    /* System.out.println(dot); */

    System.out.println(b.caminharPosOrdem());
  }
}
