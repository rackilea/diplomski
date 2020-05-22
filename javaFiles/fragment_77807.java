class MyList
{
  private int MAX = 6;
  private int size = 0;
  private int[] array;

  public MyList()
  {
    array = new int[MAX];
  }

  public void placeElementAt(int value, int index)
  {
    if (size == 0)
    {
      // If size is 0, just insert the value at index 0.
      array[size++] = value;
      return;
    }

    if (index < 0 || index >= size)
    {
      // Index is out of bounds.
      System.out.println("Invalid index.");
      return;
    }

    if (size >= MAX)
    {
      // Max capacity reached -> allocate more space.
      doubleCapacity();
    }

    // Shift all elements at and above index right by 1.
    for (int i = size - 1; i >= index; i--)
    {
      array[i + 1] = array[i];
    }

    // Insert element.
    array[index] = value;
    size++;
  }

  public void doubleCapacity()
  {
    int[] newArray = new int[MAX * 2];

    // Copy old elements to new array.
    for (int i = 0; i < size; i++)
    {
      newArray[i] = array[i];
    }

    // Double MAX to reflect new array.
    MAX *= 2;
    array = newArray;

    System.out.println("Doubled");
  }

  public void add(int value)
  {
    if (size >= MAX)
    {
      // Max capacity reached -> allocate more space.
      doubleCapacity();
    }

    // Add the element to the back of the list.
    array[size++] = value;
  }

  public void print()
  {
    for (int i = 0; i < size; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args)
  {
    MyList data = new MyList();
    data.placeElementAt(1, 0);
    data.print();
    data.placeElementAt(2, 0);
    data.print();
    data.placeElementAt(3, 0);
    data.print();
    data.placeElementAt(5, 0);
    data.print();
    data.placeElementAt(3, 0);
    data.print();
    data.placeElementAt(9, 0);
    data.print();
    data.placeElementAt(4, 0);
    data.print();
    data.placeElementAt(6, 0);
    data.print();
  }
}