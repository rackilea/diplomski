// Set orginal to true
               boolean orginal = true;
              //Convert the string into an int
              num =  Integer.parseInt(inputField.getText());
              // Loop to find the duplicate
              for(int i = 0; i < array.length; i++){
                  // Check if there's a duplicate
                  for(int j = 0; j < array.length; j++){
                      // Check if the num is equal to any of the numbers in the array
                      if(array[j] == num){
                          // Set orginal to false
                          orginal = false;
                          // Throw the duplicate exception
                          throw new DuplicateValueException(result);
                      }
                  }
                  // If there is no duplicates
                  if(orginal){
                      // Add the number to the array
                      array[index] = num;
                      // Break out the loop
                      break;
                  }

              }
              // Print the message
              System.out.println("array["+index+"] = "+ num);
              // Increment the index variable
              index++;