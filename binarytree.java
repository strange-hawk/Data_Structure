class binarytree extends node
{
	node root;

	public binarytree()
	{
		root = null;
	}

	public void insert(int key)
	{
		root = insertRec( root, key );
	}

	node insertRec(node root, int key)
	{
		if (root == null)
		{
			root = new node(key);
			return root;
		}

		else
		{
			if(key < root.data)
			{
				root.left = insertRec(root.left,key);
			}
			else if( key > root.data)
			{
				root.right = insertRec(root.right , key);
			}
			return root;
		}
	}

	void inorder()
	{
		inorderRec(root);
	}

	void inorderRec(node root)
	{
	//System.out.println("inorder ---> ");
		if(root!= null)
		{
			inorderRec(root.left);
			System.out.print(root.data+"  ->  ");
			inorderRec(root.right);
		}

	}


	void postorder()
	{
		postorderRec(root);
	}

	void postorderRec(node root)
	{
	//System.out.println("postorder ---> ");
		if(root!=null)
		{
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data+"  ->  ");
		}

	}

	void preorder()
	{
		preorderRec(root);
	}

	void preorderRec(node root)
	{
	//System.out.println("preorder ---> ");
		if(root!=null)
		{
		System.out.print(root.data+"  ->  ");
		preorderRec(root.left);
		preorderRec(root.right);
		}
	}

	node Findmin(node root)
	{
		while(root.left != null)
		{
			root = root.left;
		}
		return root;
	}

	void Delete(int x)
	{
		root = DeleteRec(root,x);
	}

  node DeleteRec(node root, int data)
	{
		if(root == null)
		{
			return root;
		}
		else if(data < root.data)
		{
			root.left= DeleteRec(root.left , data);
		}
		else if(data > root.data)
		{
			root.right = DeleteRec(root.right , data);
		}
		else
		{
			if(root.left == null && root.right == null)
			{
				//delete root;
				root = null;
			}
			else if(root.left == null)
			{
				node temp = new node();
				temp = root;
				root = root.right;
				//delete temp;
			}
			else if(root.right == null)
			{
				node temp = new node();
				temp = root;
				root = root.left;
				//delete temp;
			}
			else
			{
				node temp = Findmin(root.right);
				root.data = temp.data;
				root.right = DeleteRec(root.right , temp.data);
			}
		}
		return root;
	}



	public node searchkey(node root, int key)
	{
		if(root == null || root.data == key)
		{
			System.out.println("Element found");
			return root;
		}

		else if (root.data > key)
		{
		return  searchkey(root.left,key);
		}
		else
		return searchkey(root.right,key);
	}
	void search(int x)
	{
		root = searchkey(root,x);
	}


}
