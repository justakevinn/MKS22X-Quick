import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception


public class Quick{

  public static int partition(int[] data, int start, int end){
    Random randgen = new Random();
    int pivot = Math.abs(randgen.nextInt() % data.length);
    System.out.println("pivot: " + pivot);
    int value = data[pivot];
    System.out.println("value: " + value);
    swap(data, pivot, start);  //now the pivot value is in the beginning;
    start ++;
    while (start != end){
      if (data[start] > value){
        swap(data, start, end);
        end --;
      }
      else{
        start ++;
      }
    }

    if (data[start] < value) {
      swap(data, start, 0);
    } else {
      swap(data, start - 1, 0);
    }
    return pivot;
  }

  public static int quickSelect(int[] data, int k){
    int start = 0;
    int end = data.length-1;
    int x = partition(data, start, end);
    while (x != k){
      if (x < k){
        start = x;
        x = partition(data, start, end);
      }
      if (x > k){
        end = x;
        x = partition(data, start, end);
      }
    }
    return data[x];
  }

  public static void quickSort(int[] data){
    quickSortH(data, 0, data.length-1);
  }


  public static void quickSortH(int[] data, int lo, int hi){
    if( lo >= hi){
      return;
    }
    int pivot = partition(data, lo, hi);
    quickSortH(data, pivot+1, hi);
    quickSortH(data, lo, pivot-1);
  }

  private static void swap(int[] data, int x, int y){
    int hold = data[x];
    data[x] = data[y];
    data[y] = hold;
  }

  public static String toString(int[] data){
    String s = "[";
    for (int i = 0; i < data.length; i++){
      s = s + data[i] + ", ";
    }
    s += "]";
    return s;
  }

  public static void main(String[] args){
     int[] test = {4, 6, 1, 3, 5, 2, 23, 7, 11, 82, 30, 63, 36, 70, 12, 99, 1000};
     partition(test, 0, test.length-1);
     System.out.println(toString(test));
     System.out.println(quickSelect(test, 5));
     System.out.println(toString(test));
     quickSort(test);
     System.out.println(toString(test));

  }


}
