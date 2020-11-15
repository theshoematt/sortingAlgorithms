package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    
    private final List<Integer> array;
    private final int n;
    
    public SelectionSort(List<Integer> array) {
        this.n = array.size();
        this.array = sort(array);
    }
    
    private List<Integer> sort(List<Integer> array){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i+1; j < n; j++) {
                if (array.get(min_index) > array.get(j)) {
                    min_index = j;
                }}
            if (min_index != i) {
                Integer temp = array.get(i);
                array.set(i, array.get(min_index));
                array.set(min_index, temp);
            }}
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: "+(endTime-startTime)+"ms");
        
        return array;
    }
    
    public void print() {
        System.out.println("Sorted array using SelectionSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
       for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
       Collections.shuffle(array);
       
       System.out.println("Shuffled array:");
       System.out.println(array);
       
       (new SelectionSort(array)).print();
   }
   
}