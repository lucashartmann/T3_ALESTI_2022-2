import java.util.List;
import java.util.LinkedList;

public class BinarySearchTree{

    // Atributos
    private int count; //contagem do número de nodos
    private Nodo root; //referência para o nodo raiz

    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
