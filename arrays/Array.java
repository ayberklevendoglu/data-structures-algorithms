package arrays;
public class Array {
  private int[] items;
  private int count;
  private int temp;

  public Array(int length) {
    items = new int[length];
  }


  public void insert(int item){
    if(items.length == count){
      int[] newItems = new int[count*2];

      for (int i = 0; i < count; i++)
        newItems[i] = items[i];

      items = newItems;
    }

    items[count] = item;
    count++;
  }

  public void removeAt(int index){
    if(index < 0 || index >= count){
      throw new IllegalArgumentException();
    }

    for (int i = index; i < count - 1; i++) {
      items[i] = items[i+1];
    }
    count--;
  }

  public int indexOf(int item){
    for (int i = 0; i < count; i++) {
      if(items[i] == item)
        return i;
    }
    return -1;
  }

  // homeworks

  public int max(){
    int largestNumber = 0;
    for (int i = 0; i < count; i++) {
      if(items[i] > largestNumber){
        largestNumber = items[i];
      }
    }
    return largestNumber;
  }

  public int[] intersect(){
    int[] commonItems = new int[count];
    for (int i = 0; i < count; i++) {
      for (int j = i + 1; j < count; j++) {
        if(items[i] == items[j]){
          commonItems[i] = items[i];
          // System.out.println(commonItems[i]);
        }
      }
    }
    return commonItems;
  }

  public void reverse(){
    for (int i = 0; i < count / 2; i++) {
      temp = items[i];
      items[i] = items[count - 1 - i];
      items[count - 1 - i] = temp;
    }
  }

  public void insertAt(int item,int index){

    // create a new array with higher size
    if(index > count || index < 0){
      throw new IllegalArgumentException();
    }
    int[] newItems = new int[count*2];

    for (int i = 0; i < count; i++){
      newItems[i] = items[i];
    }
    count++;


    //loop thru new array backwards until you hit index and copy items one by one
    for(int i = count; i > index; i--){
      newItems[i] = newItems[i-1];
    }
    newItems[index] = item;
    items = newItems;
  }

  public void print(){
    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }
}
