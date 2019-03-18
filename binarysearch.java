import java.util.*;
class binarysearch{
  public static int fun(int[] a, int x)
  {
    int low = 0;
    int high = 9;
    int mid = 0;
    while(low<=high)
    {
      mid = (low+high)/2;
      if(a[mid] > x)
      high = mid - 1;
      else if (a[mid]<x)
      low = mid + 1;
      else
      return low;
    }
    return -1;
  }
  public static void main(String[] args)
  {
    int[] a = new int[]{2,4,8,10,13,18,20,25,29,30};
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
       System.out.println(fun(a,x));
  }
}
