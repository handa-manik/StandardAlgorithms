package Sorts;

public final class AllSorts {

    private AllSorts(){
        //do nothing
    }

    /**
     * The Bubble Sort is the most basic sorting algorithm and is based on 'bubbling' up of the largest value
     * The outer loop controls the iteration count while the inner loop iterates over the elements comparing
     * and exchanging them, if the condition is met. In the below method, the resultant array will be in ascending order
     *
     * The time complexity is O(n^2)
     *
     * @param arr An array of type int
     * @deprecated Use the optimized version instead
     * */
    public static void BubbleSort(int[] arr){
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
     * The time complexity is O(n^2)
     *
     * @param arr An array of type int
     * */

    public static void bubbleSortOptimized(int[] arr){
        boolean flag;
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

    /**
     * Selection sort requires the exchange of the current element in the iteration with the minimum element in the array
     * following the element. This 'selection' of the minimum element and moving it ahead in the array allows sorting.
     *
     * The time complexity is O(n^2)
     *
     * @param arr The array to be sorted of type int
     * */
    public static void SelectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * Insertion sort works like arranging cards in your hand, you move cards from right to left depending on their value.
     * Once an element is chosen, the elements to its left are moved to right until a place is found for the current element
     *
     * The time complexity is O(n^2)
     *
     * @param arr An array of type int
     * */

    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int val = arr[i];
            int j = i;
            while(j>=1 && arr[j-1] > val){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }

    /**
     * Quick Sort is a Divide and Conquer algorithm in which a partition element is decided and array is sorted around it
     * with smaller elements on one side and larger on other.
     *
     * The time complexity is O(nlogn)
     *
     * @param arr The array to be sorted of type int
     * @param left The starting index of the array to be sorted
     * @param right The end index of the array to be sorted
     * */

    public static void QuickSort(int[] arr, int left, int right){
        if(left<right){
            int partition = findPartition(arr, left, right);
            QuickSort(arr, left, partition-1);
            QuickSort(arr, partition+1, right);
        }
    }

    /**
     * A helper method sort the array using the selected partition
     * */
    private static int findPartition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        int partition = arr[left];
        while(low < high){
            while(low <=high && arr[low] <= partition){
                low++;
            }
            while(high >= 0 && arr[high] > partition){
                high--;
            }
            if(low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        arr[left] = arr[high];
        arr[high] = partition;
        return high;
    }
}
