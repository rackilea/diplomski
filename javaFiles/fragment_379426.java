else 
            {             

              if (entry < smaller && entry!=-99 )
              {
                  smaller = entry;

              }
              else if (entry > larger && entry !=-99)
              {
                  larger = entry;

              }
              count+=1;

            }

               if (entry == -99) {
               again = false;
               count --;
               }