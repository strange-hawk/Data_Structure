class arraylist
{
  protected int[] abc;
  protected int size;
  protected int buffer;

  arraylist()
  {
    abc = new int[10];
    size = 0;
    buffer = 2;
  }

    public int check_index(int index)
    {
      if (index < size-1)
      return 1;
      else
      return 0;
    }

  public void add(int index, int a)
  {
    if(index == 0 && size == 0)
    {
      abc[0] = a;
      size ++;
    }
    else if(size < buffer)
    {
      if (size >=1)
      {
        for(int i=size-1;i>=index;i--)
        {
           abc[i+1]=abc[i];
        }
        abc[index] = a;
        size++;
      }
    }
    else if (size == buffer)
    {
      int[] temp = new int[2*buffer];
      for(int i=0;i<index;i++)
      temp[i]= abc[i];
      temp[index] = a;
      for(int i = index;i<size;i++)
      temp[i+1]=abc[i];
      abc = temp;
      size++;
      buffer = 2*buffer;
    }
  }
  public void display()
  {
    for(int i=0;i<size;i++)
    {
      System.out.print(abc[i]+"   ");
    }
  }

  public int remove(int index)
  {
    int removed_element = abc[index];
    for(int i=index+1;i<size;i++)
    abc[i-1] = abc[i];
    size--;
    //abc[index] = (int)null;
    return removed_element;
  }
  public void dis_size()
  {
    System.out.println("The current size is "+size+" and buffer size is "+buffer);
  }
  public void search(int o)
  {
    int counter = 0;
    int i;
    for(i=0;i<size;i++)
    {
      if (abc[i]== o)
      {counter = 1;
      break;}
    }
    if(counter == 0)
    System.out.println("No element found");
    else if(counter==1)
    System.out.println("The index is "+i);
  }



}
