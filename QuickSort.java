package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    private final List<Integer> array;
    long runTime;
    
    public QuickSort(List<Integer> array) {
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array, 0, array.size()-1);
        long endTime = System.currentTimeMillis();
        runTime = endTime-startTime;
    }
    
    public void sort(List<Integer> array, int start, int end) {
        if (start < end) {
            int part = partition(array, start, end);
            sort(array, start, part-1);
            sort(array, part+1, end);
        }
    }
    
    public int partition(List<Integer> array, int start, int end) {
        int middle = (start+end)/2;
        int pivotIndex = middle;
        int pivot = array.get(middle);
       
        for (int i = start; i < pivotIndex; i++) {
            int right = array.get(i);
            if (right > pivot) {
                array.set(pivotIndex, right);
                array.set(i, array.get(pivotIndex-1));
                array.set(pivotIndex-1, pivot);
                pivotIndex--;
                i--;
            }
        }
            
        for (int j = middle+1; j<=end; j++) {
            int left = array.get(j);
            if (left < pivot) {
                array.set(j, array.get(pivotIndex+1));
                array.set(pivotIndex+1, pivot);
                array.set(pivotIndex, left);
                pivotIndex++;
            }
        }
            
        return pivotIndex;
    }
    
    public void print() {
        System.out.println("Sorted array using QuickSort:");
        System.out.println(array);
        System.out.println("Elapsed time: "+(runTime)+"ms");
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) { array.add(new Integer(i));}
        Collections.shuffle(array);
       
        System.out.println("Shuffled array:");
        System.out.println(array);
       
        (new QuickSort(array)).print();
   }
    
}
