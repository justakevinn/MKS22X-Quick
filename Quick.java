public class Quick{

  public int partition(int[] data, int start, int end){
    int pivot = Math.abs(randgen.nextInt() % data.length);
    int value = data[pivot];
    swap(data, pivot, start);  //now the pivot value is in the beginning;
    start ++;

    while (start != end){
      if (data[start] > value){
        swap(data, i, end);
        end --;
      }
      else{
        start ++;
      }
    }

    if (data[start] < value) {
      swap(data, start, 0)
    } else {
      swap(data, start - 1, 0);
    }
    return pivot;
  }

  public int quickSelect(int[] data, int k){
    int start = 0;
    int end = data.length;
    int x = partition(data, start, end);
    while (x != k){
      if (x < k){
        start = x;
        partition(data, start, end);
      }
      if (x > k){
        end = x;
        partition(data, start, end);
      }
    }
    return data[x];
  }



  private void swap(int[] data, int x, int y){
    int hold = int[x];
    int[x] = int[y];
    int[y] = hold;
  }


}

}
