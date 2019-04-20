class balance
{
  node root = new node();
  public balance()
  {
    root = null;
  }

  //root = null;

  public node leftrotate(node A)
  {
    node B = new node();
    B = A.right;
    A.right = B.left;
    B.left = A;
    A.height = max(height(A.left),height(A.right))+1;
    B.height = max(height(B.right),A.height)+1;
    return B;
  }

  public node rightrotate(node A)
  {
    node B = new node();
    B = A.left;
    A.left = B.right;
    B.right =  A;
    A.height = max(height(A.left),height(A.right))+1;
    B.height = max(height(B.left),A.height)+1;
    return B;
  }

  public node leftrightrotate(node A)
  {
    A.left = leftrotate(A.left);
    return rightrotate(A);
  }

  public node rightleftrotate(node A)
  {
    A.right = rightrotate(A.right);
    return leftrotate(A);
  }

  public void insert(Integer x)
  {
    root = insertRec(root,x);
  }
  public node insertRec(node root, Integer x)
  {
    if(root == null)
    {
      root = new node(x);
    }
    else if(x >root.data)
    {
      root.right=insertRec(root.right,x);
      if(height(root.left)-height(root.right) == -2)
      {
        if(x>root.right.data)
        {
          root = leftrotate(root);
        }
        else
        {
          root = rightleftrotate(root);
        }
      }
    }

    else if(x<root.data)
    {
      root.left = insertRec(root.left,x);
      if(height(root.left) - height(root.right) == 2)
      {
        if(x<root.left.data)
        {
          root = rightrotate(root);
        }
        else
        {
          root = leftrightrotate(root);
        }
      }
    }

    root.height = max(height(root.left),height(root.right))+1;
    return root;
  }

  public void inorder()
  {
    inorderRec(root);

  }

  public void inorderRec(node root)
  {
    if(root!=null)
    {
      inorderRec(root.left);
      System.out.print(root.data+"  ");
      inorderRec(root.right);
    }
  }

  public Integer height(node root)
  {
    return (root==null ? -1 : root.height);
  }

  public Integer max(Integer a,Integer b)
  {
    return (a>b ? a : b);
  }


  public void delete(Integer x)
  {
    root = deleteRec(root, x);
  }

  public node FindMin(node root)
  {
    while(root.left!=null)
    {
      root = root.left;
    }
    return root;
  }

  public node deleteRec(node root, Integer x)
  {
    if(root==null)
    {
      return null;
    }
    else if(x > root.data)
    {
      root.right = deleteRec(root.right,x);
    }
    else if(x<root.data)
    {
      root.left=deleteRec(root.left,x);
    }
    else
    {
      if(root.left == null && root.right==null)
        root = null;
      else if(root.left == null)
        root= root.right;
      else if(root.right == null)
        root = root.left;
      else
      {
        node temp= new node();
        temp = FindMin(root.right);
        root.data= temp.data;
        root.right = deleteRec(root.right,temp.data);
      }
    }

    root.height = max(height(root.left),height(root.right))+1;
    if(height(root.left) - height(root.right)==2)
    {
      if(root.left.data > root.left.left.data) //LL case
      {
        root = leftrotate(root);
      }
      else//LR case
      {
        root = rightleftrotate(root);
      }

    }
    else if(height(root.left) - height(root.right)==-2)
    {
      if(root.right.data<root.right.right.data)
      {
        root=leftrotate(root);
      }
      else
      {
        root= rightleftrotate(root);
      }
    }
    return root;
}
}

class avl
{
  public static void main(String[] args)
  {
    balance b=new balance();
    b.insert(20);
    b.insert(25);
    b.insert(15);
    b.insert(10);
    b.insert(30);
    b.insert(5);
    b.insert(35);
    b.insert(67);
    b.insert(43);
    b.insert(21);
    b.insert(10);
    b.insert(89);
    b.insert(38);
    b.insert(69);
    b.inorder();
    System.out.println("");
    b.delete(25);
    b.inorder();
    System.out.println("");
  }
}
