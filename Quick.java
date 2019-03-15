import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception


public class Quick{


  private static int partition(int[] data, int start, int end){
        if(start == end){
            return end;
        }
        Random randgen = new Random();
        int pivot = start + randgen.nextInt(end - start);
        int upper = end;
        int lower = start + 1;
        int value = data[pivot];
        data[pivot] = data[start];
        data[start] = value;
        while(upper >= lower){
            if(data[lower] > data[start]){
                value = data[upper];
                data[upper] = data[lower];
                data[lower] = value;
                upper--;
            }else{
                lower++;
            }
        }
        value = data[upper];
        data[upper] = data[start];
        data[start] = value;
        return upper;
    }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length-1;
    int x = partition(data, start, end);
    while (x != k){
      if (x < k){
        start = x + 1;
        x = partition(data, start, end);
      }
      if (x > k){
        end = x - 1;
        x = partition(data, start, end);
      }
    }
    return data[x];
  }

  public static void quicksort(int[] data){
    quicksortH(data, 0, data.length-1);
  }


  public static void quicksortH(int[] data, int lo, int hi){
    if( lo >= hi){
      return;
    }
    int pivot = partition(data, lo, hi);
    quicksortH(data, pivot+1, hi);
    quicksortH(data, lo, pivot-1);
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
     System.out.println(quickselect(test, 5));
     System.out.println(toString(test));
     quicksort(test);
     System.out.println(toString(test));

  }


}
