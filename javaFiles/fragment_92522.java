while(running == true){

      for (int i = 1; i <= anzahl; i++) {

         /* here, just call "i -1". this is basically equal to "arrayelements"
            which is not properly referenced up in your code.*/

         userList.get(i - 1).setUserTime(stopTime);
         Log.i("LoopNr:", String.valueOf(i));
      }
    }