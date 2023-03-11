import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Milli Park uygulmasına hoş geldiniz.");
        System.out.println("-------------------------------");
        System.out.println("Milli Parklar üzerinde yapmak istediğiniz işlemi lütfen aşağıdaki bilgilere bakarak seçiniz." +"\n");
        System.out.println("1-Milli Parkları ikili arama ağacına yerleştirilir, Ağacın derinliği bulunur, ağaçtaki tüm MilliPark bilgileri ekrana listelenir" + "\n" +
                "ve ağacın düğüm sayısını, dengeli ağaç olsaydı derinliğinin kaç olması gerektiği bilgileri verilir." +"\n");
        System.out.println("2- Adının ilk üç harfi girilen Milli Park'ın hangi il içinde yer aldığı bilgisi verilir." +"\n");
        System.out.println("3- Milli Park'ların bilgilerindeki kelimeler; Milli Park ağacı dolaşılarak ikili kelime ağacına eklenir ve ilgili kelimenin kaç defa bulunduğu yazdırılır." +"\n");
        System.out.println("4- Milli Park nesneleri HashTable'a yerleştirilir, adını girilen Milli Park'ın ilan tarihini görüp ilan tarihi kullanıcıdan girilen verilere göre güncellenir." +"\n");
        System.out.println("5- Milli Park nesneleri Heap veri yapısına eklenir, Yüz Ölçümlerine göre Milli Parkları Max Heap'e yerleştirir ve Yüz ölçümü en büyük 3 Milli Park'ı sıra ile Heap'ten çekerek tüm bilgileri listeler." +"\n");
        System.out.println("6- Milli Park nesneleri SimpleSorting algoritmalarıyla yüz ölçümlerine göre sıralanır ve sıralama algoritmaları özelliklerine göre raporda karşılaştırılır." + "\n");
        System.out.println("*************");
        System.out.println("Çıkmak için 7'ye basınız" +"\n");

        System.out.println("Lütfen işleminizi seçiniz:");
        int secim = input.nextInt();

        WordBinaryTree stree = new WordBinaryTree();
        BinarySearchTree tree = new BinarySearchTree();
        MilliPark.bilgiOlusturma();
        for (int j = 0; j < MilliPark.parkOlusturma().size(); j++){
            tree.insert(MilliPark.parkOlusturma().get(j));
        }

        while(true){
            switch (secim){
                case 1:
                    tree.displayInOrder(tree.root);
                    System.out.println("Ağacın derinliği: " + tree.depth(tree.root));
                    System.out.println("Ağaç dengeli olsaydı derinliğ: " + tree.dengeliMi(tree.countNode(tree.root)));
                    System.out.println("Ağaçta bulunan düğüm sayısı: " + tree.countNode(tree.root));

                    break;

                case 2:
                    Scanner kelime = new Scanner(System.in);
                    System.out.println("Bulunduğu şehri öğrenmek istediğiniz Milli Park'ın ilk 3 harfini(Büyük ve küçük harflere dikkat ederek) giriniz: ");
                    String word = kelime.nextLine();
                    tree.find(word);
                    break;

                case 3:
                    stree.traversAndInsert(tree.root);
                    stree.displayInOrder(stree.root);
                    break;

                case 4:
                    Scanner inpt = new Scanner(System.in);
                    Hashtable<String,MilliPark> table = new Hashtable<>(48);
                    for (int j = 0; j<MilliPark.parkOlusturma().size(); j ++){
                        table.put(MilliPark.parkOlusturma().get(j).getIsim(),MilliPark.parkOlusturma().get(j));
                    }
                    System.out.println("HASH TABLE:");
                    for(String i : table.keySet()){
                        System.out.println("Key: " + i);
                        System.out.println("Milli Park'ın adı: "+ table.get(i).getIsim());
                        System.out.println("Milli Park'ın bulunduğu şehir: " + table.get(i).getSehir());
                        System.out.println("Milli Park'ın kapladığı alan: " + table.get(i).getHektar());
                    }
                    System.out.println("Tarih bilgisini değiştirmek istediğiniz Milli Park'ın adını giriniz: ");
                    String milliPark = inpt.nextLine();
                    System.out.println("Milli Park bilgileri: ");
                    MilliPark park = table.get(milliPark);
                    System.out.println("Milli Park'ın adı: " + park.getIsim());
                    System.out.println("Milli Park'ın bulunduğu şehir: " + park.getSehir());
                    System.out.println("Milli Park'ın ilan yılı: " + park.getYil());
                    System.out.println("Milli Park'ın kapladığı alan: " + park.getHektar() + " ha.");
                    System.out.println("Yazmak istediğiniz tarih bilgisini gün.ay.yıl şeklinde yazınız: ");
                    String starih = inpt.nextLine();
                    park.setYil(starih);
                    table.replace(milliPark,park);
                    System.out.println("Tarih değişikliğinden sonra park bilgileri: ");
                    System.out.println("Milli Park'ın adı: " + park.getIsim());
                    System.out.println("Milli Park'ın bulunduğu şehir: " + park.getSehir());
                    System.out.println("Milli Park'ın ilan yılı: " + park.getYil());
                    System.out.println("Milli Park'ın kapladığı alan: " + park.getHektar() + " ha.");
                    break;

                case 5:
                    Heap heap = new Heap(48);
                    for(int i = 0; i < MilliPark.parkOlusturma().size(); i++){
                        heap.insert(MilliPark.parkOlusturma().get(i));
                    }
                    heap.displayMaxThreeNodes();
                    break;
                case 6:
                    SortingAlgorithms.compareAlgorithm();
                default:
                    System.out.println("Lütfen işlem numarasını doğru seçiniz!");
                    break;
            }
            System.out.println("Lütfen işleminizi seçiniz:");
            secim = input.nextInt();
            if(secim == 7){
                System.out.println("Programdan çıkılıyor...");
                break;
            }
        }
    }
}