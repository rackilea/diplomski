if("Open Locker".equalsIgnoreCase(input)) {
     //set locker opened
     isLockedOpened=true;
     jLabel2.setText("You open your locker and tap your textbooks and they appear in your inventory. The warning bell rings.");
     jLabel3.setText("You remember your next class is World History...");
 }else if("Go to World History".equalsIgnoreCase(input) && isLockedOpened=true) {
          jLabel2.setText("You walk down the hallway realizing that you still have 45 minutes until");
          jLabel3.setText("class starts. You arrive in class and sit in your desk.");
 }
 else {
     jLabel3.setText("You cannot do that right now.");
     //isLockedOpened=false;//you can set this to true or false but understand what will happen in both case.
 }