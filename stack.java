class stack extends arraylist
{
  void push(int n)
  {
    add(size,n);
  }
  void pop()
  {
    System.out.println("The removed element is "+remove(size-1));
  }
  void peek()
  {
    System.out.println("The topmost element is "+abc[size-1]);
  }
  /*int search(int n)
  {
    int counter = 1,temp;
    for (int i=0;i<size;i++)
    {
      if(abc[i]==n)
      {
        counter = 0;
        temp = i;
      }
    }
    if(counter == 0)
    {
      return temp;
    }
    else
    {
       return -1;
    }
  }*/
  void check_size()
  {
    System.out.println("The current size of stack is "+size);
  }
}
