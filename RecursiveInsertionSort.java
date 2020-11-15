package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursiveInsertionSort {
    
    private final List<Integer> array;
    
    public RecursiveInsertionSort(List<Integer> array) {
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array, this.array.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: "+(endTime-startTime)+"ms");
    }
    
    private void sort(List<Integer> array, int n) {
        if (n == 1) {return;}
        sort(array, n-1);
        
        Integer numToInsert = array.get(n-1);
        int j = n - 2;
        while (j >= 0 && array.get(j) > numToInsert) {
            array.set(j+1, array.get(j));
            j--;
        }
        array.set(j+1, numToInsert);
    }
    
    public void print() {
        System.out.println("Sorted array using RecursiveInsertionSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
        Collections.shuffle(array);
       
        System.out.println("Shuffled array:");
        System.out.println(array);
       
        (new RecursiveInsertionSort(array)).print();
   }
}
