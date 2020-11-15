package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    
    private final List<Integer> array;
    private final int n;
    
    public BubbleSort(List<Integer> array) {
        this.n = array.size();
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array);
        long endTime = System.currentTimeMillis();
        System.out.println("Elasped time: "+ (endTime - startTime) + "ms");
    }
    
    private void sort(List<Integer> array){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                Integer first = array.get(j);
                Integer second = array.get(j+1);
                if (first > second) {
                    array.set(j, second);
                    array.set(j+1, first);
                }}}}
    
    public void print() {
        System.out.println("Sorted array using BubbleSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
       for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
       Collections.shuffle(array);
       
       System.out.println("Shuffled array:");
       System.out.println(array);
       
       (new BubbleSort(array)).print();
   }

}
