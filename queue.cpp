#include<iostream>
#include<stdio.h>
using namespace std;
class Queue
{
private:
  struct node
  {
    int item;
    node *next;
  }*front, *rear;
public:
  Queue()
  {
    front = NULL;
    rear = NULL;
  }
  void insert(int data)
  {
    node *n= new node();
    n->item = data;
    n->next = NULL;
    if(rear == NULL)
    {
      front = rear = n;
    }
    else
    {
      rear->next = n;
      rear = n;
    }
  }

  int remove()
  {
    if(front == NULL)
    {
      return 0;
    }
    if(front == rear)    //list has got single element
    {
      delete front;
      front = rear = NULL;
      return 1;
    }
    node *r = front;
    front = front->next;
    delete r;
    return 1;

  }

  int getFirst()
  {
  if (front == NULL)
  {
    return -1;
  }
  else
  {
    return front->item;
  }
  }

  int count()
  {
    int c= 0;
    if (front ==rear)
    {
      return c;
    }
    node *t = front;
    while(t!=rear)
    {
      t=t->next;
      c++;
    }
    c++;
    return c;
  }

  int isEmpty()
  {
    if (front == NULL)
    return 1;
    else
    return 0;
  }

  void print()
  {
    node*t=front;
    if(isEmpty() == 0 )
    {
      while(t!=rear)
      {
        cout<<t->item<<"\t\t";
        t=t->next;
      }
      cout<<endl;
    }
    else if(isEmpty() == 1)
    {
      cout<<"The list is empty\n";
    }
  }
};

int main()
{
  Queue list1;
  list1.insert(10);
  list1.insert(20);
  list1.insert(30);
  list1.insert(40);
  list1.insert(50);
  list1.print();
  cout<<"The number of elements is "<<list1.count()<<endl;
  cout<<"The first element is "<<list1.getFirst()<<endl;
  cout<<"remove : "<<list1.remove()<<"\n";
  list1.print();
  cout<<"remove : "<<list1.remove()<<"\n";
  list1.print();
  cout<<"remove : "<<list1.remove()<<"\n";

}
