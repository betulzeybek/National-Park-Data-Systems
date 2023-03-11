import java.io.FileNotFoundException;
public class Queue {
    private int maxSize;
    private MilliPark[] queArray;
    private int front;
    private int rear;
    private int nItems;

    //Constructor method
    public Queue(int max){
        maxSize = max;
        queArray = new MilliPark[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Millipark nesnesini Queue'ya ekleyen method
    public void insert(MilliPark thePark){
        if (rear == maxSize - 1){
            rear = -1;
        }
        queArray[++rear] = thePark;
        nItems ++ ; //one more item
    }

    //Millipark nesnesini Queue'dan silen method
    public MilliPark remove(){
        MilliPark temp = queArray[front ++];
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    public MilliPark peekFront(){
        return queArray[front];
    } //Queue'nun ilk elemanını döndüren method
    public boolean isFull(){ // true if queue is full
        return (nItems == maxSize);
    } //Queue'nun dolu olup olmadığını kontrol eden method
    public boolean isEmpty(){
        return (nItems == 0);
    } //Queue'nun boş olup olmadığını kontrol eden method
    public int size(){
        return nItems;
    } //Queue'nın büyüklüğünü döndüren method

    static Queue theQueue = new Queue(48);

    //Dosyadan okuyup Queue'ya ekleyen metod
    public static void elemanEkleme() throws FileNotFoundException {
        for(int i = 0; i<MilliPark.dosyaOkuma().size(); i++){
            theQueue.insert(MilliPark.dosyaOkuma().get(i));
        }
    }
    //Queue'daki elemanları yazdıran method
    public static void elemanYazdir(){
        for (int i = 0; i<48; i++){
            MilliPark thePark = theQueue.peekFront();
            System.out.println("-----------------------------------------------");  //Küçük ve büyük liste yazdırma????
            System.out.println("Milli Park'ın adı: " + thePark.getParkAdi());
            System.out.println("Milli Park'ın bulunduğu il/iller: " + thePark.getIlAdi());
            System.out.println("Millki Park'ın ilan yılı: " + thePark.getIlanYili());
            System.out.println("Milli Park'ın kapsadığı alan: " + thePark.getYuzOlcum() + " hektar.");
            theQueue.remove();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        elemanEkleme();
        elemanYazdir();
    }
}