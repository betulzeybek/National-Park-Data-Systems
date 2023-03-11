import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MilliPark {
    //Sınıf veri tipleri
    private String ilAdi;
    private String parkAdi;
    private Integer yuzOlcum;
    private Integer ilanYili;
    private static Integer hektarSinir = 15000;
    private static int kucukHektarTop = 0; //Yüzölçümü 15000 hektardan küçük olan parklar için değişken
    private static int buyukHektarTop = 0; //Yüzölçümü 15000 hektardan büyük olan parklar için değişken
    private static List<List<MilliPark>> genelListe = new ArrayList<>(2); // 2 elemanlı genericList dizisi oluşumu
    private static List<MilliPark> kucukParkList = new ArrayList<>(); //Yüz Ölçümü 15000 hektardan küçük parkları tutmak için liste
    private static List<MilliPark> buyukParkList = new ArrayList<>(); //Yüz ölçümü 15000 hektardan büyük parkları tutmak için liste

    // Constructor method
    public MilliPark(String parkAdi, String ilAdi, Integer ilanYili, Integer yuzOlcum) {
        this.parkAdi = parkAdi;
        this.ilAdi = ilAdi;
        this.ilanYili = ilanYili;
        this.yuzOlcum = yuzOlcum;
    }

    public Integer getIlanYili() {
        return ilanYili;
    }
    public void setIlanYili(Integer ilanYili) {
        this.ilanYili = ilanYili;
    }
    public Integer getYuzOlcum() {
        return yuzOlcum;
    }
    public void setYuzOlcum(Integer yuzOlcum) {
        this.yuzOlcum = yuzOlcum;
    }
    public String getParkAdi() {
        return parkAdi;
    }
    public void setParkAdi(String parkAdi) {
        this.parkAdi = parkAdi;
    }
    public String getIlAdi() {
        return ilAdi;
    }
    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    //Dosyadan verileri okuyup Milli Park tipinde nesne oluşturan oluşturduğu nesneleri tüm sınıflarda kullanabilmek
    //için listeye atan method

    public static List<MilliPark> dosyaOkuma() throws FileNotFoundException {
        List<MilliPark> tumParklar = new ArrayList<>(); //Tüm classlarda kullanılacak dizi
        Scanner input = new Scanner(new FileInputStream("milliPark.txt"));
        while (input.hasNextLine()){
            String str = input.nextLine();
            if(str.isEmpty()){
            }
            else{
                String parkIsmi = str.split(";")[0];
                String sehir = str.split(";")[1];
                Integer yil = Integer.parseInt(str.split(";")[2]);
                Integer hektar = Integer.parseInt(str.split(";")[3]);
                MilliPark park = new MilliPark(parkIsmi, sehir, yil, hektar);
                tumParklar.add(park);
            }
        }
        return tumParklar;
    }
    //Listedeki parkları 15000'den küçük ve büyük olarak ayıran method
    public static void parkAyirma() throws FileNotFoundException {
        List<MilliPark> liste = dosyaOkuma();
        for(int i = 0; i<liste.size(); i++){
            if(liste.get(i).getYuzOlcum() < hektarSinir){
                kucukParkList.add(liste.get(i));
                kucukHektarTop += liste.get(i).getYuzOlcum();
            }
            else{
                buyukParkList.add(liste.get(i));
                buyukHektarTop += liste.get(i).getYuzOlcum();
            }
        }
    }
    public static void ekleme(){
        genelListe.add(kucukParkList);
        genelListe.add(buyukParkList);
    }
    public static void parkYazdir(List<MilliPark> liste){
        for(int i = 0; i < liste.size(); i++){
            MilliPark park = liste.get(i);
            System.out.println("-----------------------------------------------");
            System.out.println("Milli Park'ın adı: " + park.getParkAdi());
            System.out.println("Milli Park'ın bulunduğu il/iller: " + park.getIlAdi());
            System.out.println("Millki Park'ın ilan yılı: " + park.getIlanYili());
            System.out.println("Milli Park'ın kapsadığı alan: " + park.getYuzOlcum() + " hektar." );
        }
    }
    public static void yazdirma(){
        System.out.println("Yüzölçümü 15000 hektardan küçük olan parklar: " );
        parkYazdir(kucukParkList);
        System.out.println("\n" +"Yüzölçümü 15000 hektardan küçük olan parkların toplam yüzölçümü: " + kucukHektarTop + " hektar."+ "\n");
        System.out.println("Yüzölçümü 15000 hektardan büyük olan parklar: ");
        parkYazdir(buyukParkList);
        System.out.println("\n" + "Yüzölçümü 15000 hektardan büyük olan parkların toplam yüzölçümü: " + buyukHektarTop + " hektar.");
    }
    public static void main(String[] args) throws FileNotFoundException {
        dosyaOkuma();
        ekleme();
        parkAyirma();
        yazdirma();
    }
}