public class Heap {
    private BinarySearchTree.Node[] heapArray;
    private int maxSize; //size of array
    private int currentSize; //number of nodes in array

    public Heap(int max){
        maxSize = max;
        currentSize = 0;
        heapArray = new BinarySearchTree.Node[maxSize]; //Create array
    }
    public void trickleUp(int index){
        int parent = (index - 1) / 2;
        BinarySearchTree.Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].data.getHektar() < bottom.data.getHektar()){
            heapArray[index] = heapArray[parent]; //move it down
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }
    public boolean insert (MilliPark park){
        if(currentSize == maxSize){ //if array is full
            return false;
        }
        BinarySearchTree.Node node = new BinarySearchTree.Node();
        node.data = park;
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }
    public void displayMaxThreeNodes (){
        System.out.println("Heap'te bulunan yüz ölçümü en büyük olan 3 MilliPark: ");
        for(int i = 0; i<3; i++){
           BinarySearchTree.Node park = heapArray[i];
           park.displayNode();
        }
    }
}
