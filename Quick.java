public class Quick{

  public int partition(int[] data, int start, int end){
    int pivot = Math.abs(randgen.nextInt() % ary.length);
    int value = data[pivot];
    swap(data, pivot, start);  //now the pivot value is in the beginning;
    start ++;

    while (start != end){
      if (data[start] > value){
        swap(ary, i, end);
        end --;
      }
      else{
        start ++;
      }
    }

    if (data[start] > value) {
      data[pivot] = data[start - 1];
      data[start - 1] = value;
      pivot = start - 1;
    } else {
      data[pivot] = data[start];
      data[start] = value;
      pivot = start;
    }

  }

  public void swap(int[] ary, int x, int y){
    int hold = int[x];
    int[x] = int[y];
    int[y] = hold;
  }


}

}
