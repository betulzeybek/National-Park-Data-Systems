import java.io.FileNotFoundException;
public class StackMilli {
    private int maxSize;
    private MilliPark[] stackArray;
    private int top;
    public StackMilli(int max){  //Constructor Method
        maxSize = max; // parametre olarak girilen max değerini Dizinin size'ı olarak alıyor.
        stackArray = new MilliPark[maxSize];
        top = -1;  //Listede eleman olmadığını gösteriyor.
    }
    public void push(MilliPark p){ //Milli park nesnesini diziye ekleyen metod
        stackArray[++top] = p;
    } //Milli park nesnesini diziye atan method
    public MilliPark pop(){  //Diziden Milli Park nesnesini çıkartan diziden silen metod
        return stackArray[top--];
    } //Milli park nesnesini listeden çıkartıp silen method
    public MilliPark peek(){ //Diziden Milli Park nesnesini çıkartan fakat diziden silmeyen metod
        return stackArray[top];
    } //Milli park nesnesini listeden çıkartan method
    public boolean isEmpty(){  //Dizi boşsa True döndürüyor.
        return (top == -1);
    } //Dizinin boş olup olmadığını kontrol eden metod

    static StackMilli stack = new StackMilli(48);

    public static void elemanEkleme() throws FileNotFoundException {
        for(int i = 0; i<MilliPark.dosyaOkuma().size(); i++){
            stack.push(MilliPark.dosyaOkuma().get(i));
        }
    }
    //Listedeki elemanları yazdırma
    public static void elemanYazdir(){
        for (int i = 0; i<48; i++){
            MilliPark thePark = stack.pop();
            System.out.println("-----------------------------------------------");
            System.out.println("Milli Park'ın adı: " + thePark.getParkAdi());
            System.out.println("Milli Park'ın bulunduğu il/iller: " + thePark.getIlAdi());
            System.out.println("Millki Park'ın ilan yılı: " + thePark.getIlanYili());
            System.out.println("Milli Park'ın kapsadığı alan: " + thePark.getYuzOlcum() + " hektar.");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        elemanEkleme();
        elemanYazdir();
    }
}