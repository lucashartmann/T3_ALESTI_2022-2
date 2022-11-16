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

  public Integer getElement() {
    return element;
  }

  public boolean contains(Integer item) {
    int comp = item.compareTo(element);
    if (comp == 0)
      return true;
    if (comp < 0 && left != null && left.contains(item))
      return true;
    if (comp > 0 && right != null && right.contains(item))
      return true;
    // no matching node was found
    return false;
  }
}
