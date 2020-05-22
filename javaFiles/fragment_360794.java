public int getLargestMobileIndex(ArrayList<Element> elements)
      {
         int maxIndex = 0;

         for(int i = 0; i < elements.size(); i++)
         {
            if(elements.get(i).isMobile() && i > maxIndex) //<---------- It seems that 
            // you should compare the i-th element to the maxIndex-th element, not i and
            // maxIndex
            {
               maxIndex = i;
            }
         }

         return maxIndex;
      }