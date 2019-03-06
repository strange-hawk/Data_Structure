class LinkedList
{
  protected Node START;
  protected Integer size;
  LinkedList()
  {
    START = null;
    size = 0;
  }

  void AddAtStart(int d)
  {
    Node temp = new Node();
    temp.data = d;
    temp.next = null;
    if(START == null)
    {
      START = temp;
    }
    else
    {

      temp.next = START;
      START = temp;
    }
    size++;
  }

  void AddAfter(int index,int d)
  {
    Node temp = new Node();
    temp = START;
    if(index < 0 || index >=size)
    throw new IndexOutOfBoundsException();
    else
    {
      for(int i=0;i<index;i++)
      {
        temp = temp.next;
      }
      Node n = new Node();
      n.data = d;
      n.next = temp.next;
      temp.next = n;

    }
  }

  void AddAtEnd(int d)
  {
    Node temp = new Node();
    temp = START;
    Node n = new Node();
    n.data = d;
    n.next = null;
    while (temp.next != null)
    {
      temp = temp.next;
    }
    temp.next = n;
    size++;
  }

  void print()
  {
    Node temp = new Node();
    temp = START;
    while(temp!=null)
    {
      System.out.print(+temp.data+"   ");
      temp=temp.next;
    }
  }

  int remove(int index)
  {
    if(index < 0 || index >=size)
    throw new IndexOutOfBoundsException();
    else
    {
      Node temp = new Node();
      int  removed_element;
      temp = START;
      for(int i=0;i<index-1 ; i++)
      {
        temp = temp.next;
      }
      removed_element = temp.data;
      temp.next = temp.next.next;
      return removed_element;
    }
  }

}
