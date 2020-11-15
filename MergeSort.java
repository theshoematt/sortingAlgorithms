package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {

    private final List<Integer> array;
    
    public MergeSort(List<Integer> array) {
        this.array = array;
        
        long startTime = System.currentTimeMillis();
        sort(this.array, 0, array.size()-1);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: "+(endTime-startTime)+"ms");
    }
    
    private void sort(List<Integer> array, int start, int stop) {
        if (start < stop) {
            int middle = (start+stop)/2;
            sort(array, start, middle);
            sort(array, middle+1, stop);
            merge(array, start, middle, stop);
        }
    }
    
    private void merge(List<Integer> array, int start, int middle, int stop) {
        
        List<Integer> temp1 = new ArrayList<Integer>();
        List<Integer> temp2 = new ArrayList<Integer>();
        int n1 = middle - start + 1;
        int n2 = stop - middle;
        for (int x = 0; x < n1; x++) { temp1.add(array.get(start+x));}
        for (int x = 0; x < n2; x++) { temp2.add(array.get(middle+x+1));}
        
        int x = 0;
        int y = 0;
        int z = start;
        while (x < n1 && y<n2) {
            Integer e1 = temp1.get(x);
            Integer e2 = temp2.get(y);
            if (e1 <= e2) {
                array.set(z, e1);
                x++;
            } else {
                array.set(z, e2);
                y++;
            }
            z++;
        }
        
        while (x < n1) {
            array.set(z, temp1.get(x));
            x++;
            z++;
        }
        
        while (y < n2) {
            array.set(z, temp2.get(y));
            y++;
            z++;
        }
    }
    
    public void print() {
        System.out.println("Sorted array using MergeSort:");
        System.out.println(array);
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 5000; i++) { array.add(new Integer(i));}
        Collections.shuffle(array);
       
        System.out.println("Shuffled array:");
        System.out.println(array);
       
        (new MergeSort(array)).print();
   }
}
