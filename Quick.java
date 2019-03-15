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
        swap(data, pivot, start);
        while(upper >= lower){
            if(data[lower] > data[start]){
                swap(data, upper, lower);
                upper--;
            }else{
                lower++;
            }
        }
        swap(data, start, upper);
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

  /*public static void main(String[] args){
     int[] test = {4, 6, 1, 3, 5, 2, 23, 7, 11, 82, 30, 63, 36, 70, 12, 99, 1000};
     partition(test, 0, test.length-1);
     System.out.println(toString(test));
     System.out.println(quickselect(test, 5));
     System.out.println(toString(test));
     quicksort(test);
     System.out.println(toString(test));

  }*/

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}


}
