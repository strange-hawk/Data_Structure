#include<iostream>
using namespace std;
class linkedlist
{
private:
  struct Node
  {
    int data;
    Node* next;
    //int size=0;
  };
  Node* START = NULL;
  int size = 0;

public:
  void insertAtStart(int x)
  {
    Node* d = new Node();
    d -> data= x;
    d -> next = NULL;
    if(START==NULL)
    {
      START=d;
    }
    else
    {
      Node* temp= START;

      START = d;
      START->next = temp;
    }
    size++;
  }

  void insertAtEnd(int x)
  {
    Node* d = new Node();
    d->data = x;
    d->next = NULL;
    Node* temp = START;
    while(temp->next!=NULL)
    {
      temp=temp->next;
    }
    temp->next = d;
    size++;
  }

  void display()
  {
    Node* temp = START;
    while(temp!=NULL)
    {
      cout<<temp->data<<" ";
      temp=temp->next;
    }
    cout<<size<<"\n";
  }

  void insertAddAfter(int key,int pos)
  {
    if(pos<1 || pos > size)
    {
      cout<<"enter valid position";
    }
    else
    {
      Node* s = new Node();
      s->data=key;
      s->next= NULL;
      Node* temp = START;
      for(int i=1;i<pos;i++)
      {
        temp=temp->next;
      }
    //temp is pointing the pos position
      Node* t = temp->next;
    //t is pointing the pos+1 position
      temp->next = s;
      s->next = t;
    }
    size++;
  }

  void remove(int pos)
  {
    Node* temp = START;
    if(pos == 1)
    {
      START=START->next;
    }
    if(pos == size)
    {
      for(int i=1;i<pos-1;i++)
      {
        temp=temp->next;
      }
      //temp is pointing 1 node before the node to be deleted
      temp->next=NULL;
    }
    else
    {
      for(int i=1;i<pos-1;i++)
      {
        temp=temp->next;
      }
      temp->next=temp->next->next;
    }
    size--;
  }

  void sort()
  {
    Node*temp = START;
    int key;
    for(Node* i=temp;i!=NULL;i=i->next)
    {
      for(Node* j=i->next;j!=NULL;j=j->next)
      {
        if(i->data > j->data)
         key = i->data;
         i->data = j->data;
         j->data = key;
      }
    }
  }

  void search(int x)
  {
    Node* temp = START;
    int counter = 0;
    int pos=1;
    while(temp->next!=NULL)
    {
      if(temp->data == x)
      {
        counter=1;
        break;
      }
      temp=temp->next;
      pos++;
    }
    if(counter==1)
    {
      cout<<"The element is found at position "<<pos<<"\n";
    }
    else if(counter==0)
    {
      cout<<"Unable to find element\n";
    }

  }

};

//driver function
int main()
{
  linkedlist l;
  l.insertAtStart(12);
  l.insertAtStart(23);
  l.insertAtStart(34);
  l.insertAtStart(45);
  l.insertAddAfter(78,3);
  l.insertAddAfter(89,1);
  l.insertAddAfter(100,6);
  l.insertAtEnd(56);
  l.display();
  l.remove(1);
  l.remove(7);
  l.remove(3);
  l.display();
  //l.sort();
  //l.display();
  l.search(23);
  l.search(34);
}
