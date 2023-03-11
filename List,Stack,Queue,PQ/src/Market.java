import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Market {
    static Queue<Integer> urunSay = new LinkedList<>();
    private static Integer[] dizi = new Integer[]{8, 9, 6, 7, 10, 1, 11, 5, 3, 4, 2};
    private static int kasaSure = 3;
    static List<Integer> musteriler = new ArrayList<>();

    //Boş Constructor Method
    public Market(){
    }

    //Get ve set metodları
    public Integer[] getDizi() {
        return dizi;
    }
    public void setDizi(Integer[] dizi) {
        this.dizi = dizi;
    }
    public int getKasaSure() {
        return kasaSure;
    }
    public void setKasaSure(int kasaSure) {
        this.kasaSure = kasaSure;
    }
    public Queue<Integer> getUrunSay() {
        return urunSay;
    }
    public void setUrunSay(Queue<Integer> urunSay) {
        this.urunSay = urunSay;
    }

    //Müşteriler listesine ürün sayısı ekleyen method
    public static void ekle(Integer urunSay){
        musteriler.add(urunSay);
    }

    //Kuyruktaki müşterilerin kasada kalma sürelerini hesaplayan method
    public static void sureHesaplama(){
        double topSure = 0;
        double oncekiSure = 0;

        for (int i = 0; i<11; i++){
            urunSay.add(dizi[i]);
        }
        for(int i = 0; i<11; i++){
            int urun = urunSay.poll();
            double sure = urun * kasaSure;
            oncekiSure += sure;
            topSure += oncekiSure;
            System.out.println((i+1) + ". Müşterinin işlem tamamlanma süresi: " + oncekiSure +" saniye.");
        }
        double ortalama = topSure /11;
        System.out.println("Kuyruk yapısı için kasanın ortalama işlem tamamlama süresi: " + ortalama+ " saniye.");
    }

    //Öncelikli Kuyruktaki müşterilerin kasada kalma sürelerini hesaplayan method
    public static void pqSureHesaplama(){
        int oncekiSure = 0;
        int topSure = 0;
        int sayac = 0;
        for(int j = 0; j< 11; j++){
            int min = 999; //Burayı tekrar düşün
            for (int i = 0; i< musteriler.size() ; i++){
                if(min > musteriler.get(i)){
                    min = musteriler.get(i);
                    sayac = i;
                }
            }
            int sure = min * 3;
            oncekiSure += sure;
            topSure += oncekiSure;
            musteriler.remove(sayac);
            System.out.println( (j + 1) + ". Müşterinin işlem tamamlanma süresi: " + oncekiSure + " saniye." );
        }
        System.out.println("Öncelikli kuyruk yapısı için kasanın ortalama işlem tamamlama süresi: " + topSure/11 + " saniye");
    }

    public static void main(String[] args) {
        sureHesaplama();
        for (int i = 0; i < 11; i++) {
            ekle(dizi[i]);
        }
        pqSureHesaplama();
    }
}