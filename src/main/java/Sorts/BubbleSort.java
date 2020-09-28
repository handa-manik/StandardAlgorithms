package Sorts;

/**
 * Sorting using bubble sort
 *
 * @author Manik Handa
 * */
public class BubbleSort {

    /**
     * The Bubble Sort is the most basic sorting algorithm and is based on 'bubbling' up of the largest value
     * The outer loop controls the iteration count while the inner loop iterates over the elements comparing
     * and exchanging them, if the condition is met. In the below method, the resultant array will be in ascending order
     *
     * @param arr An array of type int
     * @return void
     * @deprecated Use the optimized version instead
     * */
    public void BubbleSort(int[] arr){
        for(int i = arr.length - 1; i>=0; i--){
            for(int j=0; j<i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * An improvement over the regular bubble sort. If during any inner loop run, there are no exchanges made, the array
     * considered to be completely ordered. A boolean flag is used to track this condition and is checked after every inner loop run.
     *
     * @param arr An array of type int
     * @return void
     * */

    public void bubbleSortOptimized(int[] arr){
        boolean flag = false;
        for(int i=arr.length-1; i>=0; i--){
            flag = false;
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag) return;
        }
    }

}
