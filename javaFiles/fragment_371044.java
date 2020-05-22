case 'F':
 case 'f': 
        if(start < end || (start < 0 && end < 0 && end > start))  // start < end or start = -3 and end = -7
        {
            for (int i=start; i<=end; i+=inc) 
            {                     
                System.out.print(i + " ");
            }
        }
        else if(start > end || (start < 0 && end < 0 && start > end))  //  if start = - 7 and end = -3
        { 
            for (int i=end; i>=start; i-=inc) // should be greater than 
            {                
                System.out.print(i + " ");                    
            }
        }
        else if(start == end)
        {
          System.out.println(end);
        }