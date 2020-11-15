package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursiveBubbleSort {
    
    private final List<Integer> array;
    
    public RecursiveBubbleSort(List<Integer> array) {
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array, this.array.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: "+(endTime-startTime)+"ms");
    }
    
    private void sort(List<Integer> array, int n){
        if (n == 1) { return;}
        for (int i = 0; i < n-1; i++) {
            Integer first = array.get(i);
            Integer second = array.get(i+1);
            if (first > second) {
                array.set(i, second);
                array.set(i+1, first);
            }}
        sort(array, n-1);
    }
    
    public void print() {
        System.out.println("Sorted array using RecursiveBubbleSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
       for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
       Collections.shuffle(array);
       
       System.out.println("Shuffled array:");
       System.out.println(array);
       
       (new RecursiveBubbleSort(array)).print();
   }
}
