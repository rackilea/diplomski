ButtonGoBack.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {

                try
                {                             
                 enumCounter--;

                 temporaryValue = values[enumCounter];

                 doSomething(temporaryValue);
                  // hides button              
                  if(enumCounter== 0)
                  {
                      ButtonGoBack.setVisibility(4);
                  }
                 } 
                 catch(Exception e)
                 {
                   ButtonGoBack.setVisibility(4);
                   enumCounter++;          
                 }
               }        
           });