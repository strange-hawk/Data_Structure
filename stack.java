class stack extends LinkedList
{
  void push(int n)
  {
    if(START == null)
    {
      AddAtStart(n);
    }
    else
    {
      AddAtEnd(n);
    }
  }
  void pop()
  {
    if(size == 0)
    {
      System.out.println("Empty stack");
    }
    else
    {
    System.out.println("The popped element is "+remove(size-1));
    }
  }
  void peep()
  {
    Node temp = new Node();
    temp = START;
    if(START == null)
    {
      System.out.println("empty");
    }
    else
    {
      while(temp.next!=null)
      {
        temp = temp.next;
      }
      System.out.println("The topmost element is "+temp.data);
    }
  }
  void search(int n)
  {
    if(START == null)
    {
      System.out.println("empty");
    }
    else
    {
      int counter=0;
      Node temp = new Node();
      temp = START;
      while(temp.next!=null)
      {
        if(temp.data == n)
        {
          counter = 1;
          break;
        }
        else
        {
          temp=temp.next;
        }
      }
      if(counter == 1)
      {
        System.out.println("Element found");
      }
      else
      {
        System.out.println("No such element is present");
      }
    }
  }
  void check_size()
  {
    System.out.println("The current size of stack is "+size);
  }
}
