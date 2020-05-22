public void AddItem(String value)
  {
      // Check if cursor at last
      if(noOfItems + 1 == maxcap){
        // Resize data
        maxcap *= 2;
        String[] newData = new String[maxcap];
        System.arraycopy(data, 0, newData, 0, noOfItems);
        data = newData;
      }

      // find the last element according to value
      int idx = 0;
      for(; idx<noOfItems; idx++){
        if(data[idx].compareToIgnoreCase(value) >= 0) {
          break;
        }
      }

      // move elements if required
      if(idx < noOfItems){
        System.arraycopy(data, idx, data, idx+1, noOfItems-idx);
      }

      // set element on index
      data[idx] = value;

      noOfItems++;

      System.out.println("adding: "+value);
  }