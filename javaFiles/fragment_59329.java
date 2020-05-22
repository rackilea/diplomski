if(quant>Integer.parseInt(book.getQuantity()))
      {   
             //Loop 1  , this is executing if any of the quant is greater then book.getQuantity()..                    
            //i want to stop executing LOOP2 ,if any of the value of quant is greater then book.getQuantity().
          addActionError("You have entered an invalid quantity for the Book Title- ''"+book.getBookTitile()+"''."); 
          break; 
      }