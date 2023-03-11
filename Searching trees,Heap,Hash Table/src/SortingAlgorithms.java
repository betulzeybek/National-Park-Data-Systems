import java.io.FileNotFoundException;
public class SortingAlgorithms {
    public static void bubbleSort(MilliPark dizi[]){
        for(int i = 0; i < dizi.length - 1 ; i++){
            for(int j = 0; j < dizi.length - i - 1; j++){
                if(dizi[j].getHektar() > dizi[j + 1].getHektar()){
                    //swap
                    MilliPark temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
    }
    public static void selectionSort(MilliPark dizi[]){
        for(int i = 0; i < dizi.length - 1 ; i++){
            int index = i;
            for(int j = i + 1; j < dizi.length; j++){
                if(dizi[j].getHektar() < dizi[index].getHektar()){
                    index = j;
                }
            }
            MilliPark kucukPark = dizi[index];
            dizi[index] = dizi[i];
            dizi[i] = kucukPark;
        }
    }
    public static void insertionSort(MilliPark dizi[]){
        for(int i = 1; i < dizi.length; ++i){
            MilliPark key = dizi[i];
            int j = i - 1;
            while( j >= 0 && dizi[j].getHektar() > key.getHektar()){
                dizi[j + 1] = dizi[j];
                j = j - 1;
            }
            dizi[j + 1] = key;
        }
    }
    public static void compareAlgorithm() throws FileNotFoundException {
        MilliPark[] dizi = new MilliPark[MilliPark.parkOlusturma().size()];

        for(int i = 0; i < MilliPark.parkOlusturma().size(); i++){
            dizi[i] = MilliPark.parkOlusturma().get(i);
        }
        SortingAlgorithms.bubbleSort(dizi);
        SortingAlgorithms.insertionSort(dizi);
        SortingAlgorithms.selectionSort(dizi);
    }
}
