package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

    private final List<Integer> array;
    
    public InsertionSort(List<Integer> array) {
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: "+(endTime-startTime)+"ms");
    }
    
    private void sort(List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            Integer numToInsert = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > numToInsert) {
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1, numToInsert);
        }
    }
    
    public void print() {
        System.out.println("Sorted array using InsertionSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
       for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
       Collections.shuffle(array);
       
       System.out.println("Shuffled array:");
       System.out.println(array);
       
       (new InsertionSort(array)).print();
   }
}
