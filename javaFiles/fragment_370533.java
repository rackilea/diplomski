public String toString()
  {
    String result = String.format("There are %d items in the queue.", count);
    if (count == 0)
    {
      return result;
    }
    else if (front >= back)
    {
      for (int i = front; i < count; i++)
      {
        result += queue[i].toString() + "\n";
      }
      for (int i = 0; i < back; i++)
      {
        result += queue[i].toString() + "\n";
      }
    }
    else
    {
      for (int i = front; i < back; i++)
      {
        result += queue[i].toString() + "\n";
      }
    }
    return result;
  }