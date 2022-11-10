public class Nodo {

  public Nodo parent;
  public Nodo left;
  public Nodo right;
  public Integer element;

  public Nodo(Integer element) {
    parent = null;
    left = null;
    right = null;
    this.element = element;
  }
}
