import java.io.FileNotFoundException;
public class BinarySearchTree {
    static class Node{
        MilliPark data; //Node'lar MilliPark sınıfı objesi bu kısım string mi olucak MilliPark mı anlamadım
        Node leftChild;  //Düğümün sol çocuğu
        Node rightChild; //Düğümün sağ çocuğu

        public Node(){
            data = null;
            leftChild = null;
            rightChild = null;
        }
        public void displayNode(){
            System.out.println("-------------------------");
            System.out.println("Milli Park'ın adı: " + data.getIsim());
            System.out.println("Milli Park'ın bulunduğu şehir: " + data.getSehir());
            System.out.println("Milli Park'ın ilan yılı: " + data.getYil());
            System.out.println("Milli Park'ın kapladığı alan: " + data.getHektar() + " ha.");
            displayParagraf();
        }
        private void displayParagraf(){
            for (int j = 0; j < data.getParagraf().size(); j ++){
                System.out.println(data.getParagraf().get(j));
            }
        }
    }
    public Node root; //Ağacın ilk node'u
    public BinarySearchTree(){ //Constructor method
        root = null;
    }
    public static boolean letterCompare(String a, String b){
        int compare = a.compareTo(b);
        if (compare < 0){ //a b'den sonra geliyor (küçük)
            return false;
        } else if (compare > 0) { //a b'den önce geliyor(büyük)
            return true;
        }

        return false;
    }
    void insert(MilliPark park) throws FileNotFoundException {
        Node node = new Node();
        node.data = park;
        if (root == null){
            root = node;
        }
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(letterCompare(park.getIsim(), current.data.getIsim())){ //node.data küçükse girer
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
    public void find (String word){
        Node current = root;
        while (true)
        {
            String aranan= current.data.getIsim().substring(0,3);

            if(aranan.equalsIgnoreCase(word)){
                System.out.println("Aradığınız Milli Park'ın adı: " + current.data.getIsim());
                System.out.println("Aradığınız Milli Park'ın bulunduğu il: " + current.data.getSehir());
                break;
            }
            if(letterCompare(word,aranan)){
                current = current.leftChild;
            }
            else{
                current = current.rightChild;
            }
            if (current == null){
                System.out.println("Aradığınız park ağaçta bulunamadı!!");
                break;
            }
        }
    }
    public void displayInOrder(Node localRoot){
        if (localRoot != null){
            displayInOrder(localRoot.leftChild);
            localRoot.displayNode();
            displayInOrder(localRoot.rightChild);
        }
    }
    public int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.leftChild);
        int rightDepth = depth(root.rightChild);
        int bigger = Math.max(leftDepth, rightDepth);
        return bigger + 1;
    }
    public int countNode(Node root){
        if(root==null)
            return 0;
        return 1 + countNode(root.leftChild) + countNode(root.rightChild);
    }
    public Double dengeliMi(int nodeSay){
        return Math.log(nodeSay)/Math.log(2);
    }
}