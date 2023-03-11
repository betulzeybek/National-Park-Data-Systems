import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MilliPark {
    private String isim;
    private String sehir;    //Milli park sınıfı için gerekli değişkenler
    private String yil;
    private Integer hektar;
    private List<String> paragraf;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public Integer getHektar() {
        return hektar;
    }

    public void setHektar(Integer hektar) {
        this.hektar = hektar;
    }

    public List<String> getParagraf() {
        return paragraf;
    }

    public void setParagraf(List<String> paragraf) {
        this.paragraf = paragraf;
    }

    //Constructor method
    public MilliPark(String isim, String sehir, String yil, Integer hektar, List<String> paragraf){
        this.hektar = hektar;
        this.isim = isim;
        this.yil = yil;
        this.sehir = sehir;
        this.paragraf = paragraf;
    }

    //Milli park sınıfından park oluşturan ve onları parklar listesine atan method method
    public static List<MilliPark> parkOlusturma () throws FileNotFoundException {
        List<MilliPark> parklar = new ArrayList<>();
        Scanner input = new Scanner(new FileInputStream("milliPark.txt"));
        int i = 0;
        while (input.hasNextLine()){
            String str = input.nextLine();
            if(str.isEmpty()){
            }
            else{
                String isim = str.split(";")[0];
                String sehir = str.split(";")[1];
                String yil = str.split(";")[2];
                Integer hektar =Integer.parseInt(str.split(";")[3]);
                List<String> paragraf =  bilgiOlusturma().get(i);
                MilliPark park = new MilliPark(isim, sehir, yil, hektar,paragraf);
                parklar.add(park);
                i++;
            }
        }
        return parklar;
    }

    //parkBilgileri.txt dosyasından paragrafları alıp List'e atan method
    public static List<List<String>> bilgiOlusturma() throws FileNotFoundException {
        List<List<String>> bilgiler = new ArrayList<>(); //Tüm parkların bilgileri bu listede tutuluyor.
        Scanner input =  new Scanner(new FileInputStream("parkBilgileri.txt"));
        while (input.hasNextLine()){
            List<String>bilgi = new ArrayList<>(); //Bir parkın bilgileri bu listede tutuluyor.
            String str = input.nextLine();
            if(str.isEmpty()){
            }
            else{
                String[] deneme = str.split("/");
                for (int j = 0; j<deneme.length; j++){
                    bilgi.add(deneme[j]);
                }
                bilgiler.add(bilgi);
            }
        }
        return bilgiler;
    }
}
