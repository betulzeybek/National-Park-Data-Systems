import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class PriorityQueue {
    static List<MilliPark> parklar = new ArrayList<>();

    public PriorityQueue(){ //Boş Constructor method
    }

    //PQ'ya Millipark nesnesini ekleyen method
    private static void elemanEkle() throws FileNotFoundException {
        for(int i = 0; i<MilliPark.dosyaOkuma().size(); i++){
            parklar.add(MilliPark.dosyaOkuma().get(i));
        }
    }

    //PQ'daki elemanları sıralayıp silen method
    private static void elemanSilme(){
        int sayac = 0;
        MilliPark deneme = null;
        int aranan = parklar.get(0).getYuzOlcum();

        for(int i = 1; i<parklar.size();i++){
            if(parklar.get(i).getYuzOlcum() < aranan ){
                aranan = parklar.get(i).getYuzOlcum();
                deneme = parklar.get(i);
                sayac = i;
            }
        }
        if(aranan == parklar.get(0).getYuzOlcum() ){
            deneme = parklar.get(0);
            sayac = 0;
        }
        parklar.remove(sayac);
        System.out.println("-----------------------------------------------");
        System.out.println("Milli Park'ın adı: " + deneme.getParkAdi());
        System.out.println("Milli Park'ın bulunduğu il/iller: " + deneme.getIlAdi());
        System.out.println("Millki Park'ın ilan yılı: " + deneme.getIlanYili());
        System.out.println("Milli Park'ın kapsadığı alan: " + deneme.getYuzOlcum() + " hektar.");
    }
    //PQ'nun boş olup olmadığını kontrol eden method
    private static Boolean isEmpty(){
        if(parklar.size() == 0){
            System.out.println("Listede eleman bulunamadı. Liste Boş!");
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        elemanEkle();
        for(int i = 0; i<48; i++){
            elemanSilme();
        }
        isEmpty();
    }
}