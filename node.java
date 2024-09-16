public class node
{
 Integer data;
 node left;
 node right;
 Integer height;

  public node()
  {
    this(null);
  }
  public node(Integer key)
  {
    this.data = key;
    this.left = this.right = null;
    this.height = 0;
  }
}
