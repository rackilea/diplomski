for (int i = length- 1; i>1;i++)
      {

          if (data[length -1].compareTo(data[length]) > 0)
                  {
                      data[length-1] = temp;
                      data[length]=data[length -1];
                      temp = data[length];
                  }
      }