public class WordBinaryTree {
    static class WordBinaryTreeNode{
        String data;
        WordBinaryTreeNode leftChild;  //Düğümün sol çocuğu
        WordBinaryTreeNode rightChild; //Düğümün sağ çocuğu<
        Integer count;

        public WordBinaryTreeNode(){
            data = null;
            leftChild = null;
            rightChild = null;
            count = 0;
        }
        public void displayNode(){
            System.out.println(data + " kelimesi kelime ağacında " + (count) + " defa bulunuyor.");
        }
    }
    public WordBinaryTreeNode root; //Ağacın ilk node'u

    public WordBinaryTree() {
        root = null;
    }
    public void insertString(String str) {
        WordBinaryTreeNode node = new WordBinaryTreeNode();
        node.data = str;

        if (root == null) {
            root = node;
        }
        else{
            WordBinaryTreeNode current = root;
            WordBinaryTreeNode parent;
            while (true){
                parent = current;

                int karsilastirma = str.compareTo(parent.data);

                if(karsilastirma < 0){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        parent.leftChild.count = 1;
                        return;
                    }
                } else if (karsilastirma == 0) {
                    parent.count ++;
                    return;
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        parent.rightChild.count = 1;
                        return;
                    }
                }
            }
        }
    }
    public void displayInOrder(WordBinaryTreeNode localRoot){
        if (localRoot != null){
            displayInOrder(localRoot.leftChild);
            localRoot.displayNode();
            displayInOrder(localRoot.rightChild);
        }
    }
    public void traversAndInsert(BinarySearchTree.Node localRoot){ //Millipark ağacını dolaşıp kelimeleri diğer ağğaca ekliyor.
        if(localRoot != null){
            traversAndInsert(localRoot.leftChild);
            for(int i = 0; i < localRoot.data.getParagraf().size(); i ++){
                String s = localRoot.data.getParagraf().get(i);
                String[] str = s.split(" ");
                for(int j = 0; j < str.length; j ++){
                    insertString(str[j]);
                }
            }
            traversAndInsert(localRoot.rightChild);
        }
    }
}