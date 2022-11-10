import java.util.List;
import java.util.ArrayList;
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

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        Nodo aux = new Nodo(element);
        if (root == null) { // Se for o primeiro elemento, cria como raiz e retorna
            root = aux;
            return;
        }
        if(aux.element <= root.element && root.left == null){
            root.left = aux;
            aux.parent = root;
            return;
        }
        else if(aux.element > root.element && root.right == null){
            root.right = aux;
            aux.parent = root;
            return;
        }

        Nodo pai = root;
        boolean adicionouControle = false;

        while(!adicionouControle){
            if(aux.element <= pai.element){
                if(pai.left == null){
                    pai.left = aux;
                    aux.parent = pai;
                    adicionouControle = true;
                }
                else{
                    pai = pai.left;
                }
            }else{
                if(pai.right == null){
                    pai.right = aux;
                    aux.parent = pai;
                    adicionouControle = true;
                }
                else{
                    pai = pai.right;
                }
            }
        }
    }
    
    // Completar
    public boolean contains(Integer element)
    {
        Nodo atual = root;
        return false;
    }

    public List<Integer> caminharPreOrdem() {
        List<Integer> list = new ArrayList<>();
        preOrdemRecursivo(list, root);
        return list;
    }

    public void preOrdemRecursivo(List<Integer> caminho, Nodo nodo) {
        caminho.add(nodo.element);
        if(nodo.left!=null) preOrdemRecursivo(caminho, nodo.left);
        if(nodo.right!=null) preOrdemRecursivo(caminho, nodo.right);
    }







    public List<Integer> positionsCentral() {
        List<Integer> res = new LinkedList<>();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Nodo n, List<Integer> res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    private void geraConexoesDOT(StringBuilder sb, Nodo nodo) {
        if (nodo == null) {
            return;
        }

        geraConexoesDOT(sb, nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            sb.append("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" \n");
        }

        geraConexoesDOT(sb, nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            sb.append("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" \n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void geraNodosDOT(StringBuilder sb, Nodo nodo) {
        if (nodo == null) {
            return;
        }
        geraNodosDOT(sb,nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        sb.append("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]\n");
        geraNodosDOT(sb,nodo.right);
    }

    public void geraConexoesDOT(StringBuilder sb) {
        geraConexoesDOT(sb, root);
    }

    public void geraNodosDOT(StringBuilder sb) {
        geraNodosDOT(sb,root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public String toDOT() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph g { \nnode [shape = record,height=.1];\n");
        geraNodosDOT(sb);
        geraConexoesDOT(sb);
        sb.append("}\n");
        return sb.toString();
    }
}
