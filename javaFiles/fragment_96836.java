if(likes[index].listIterator(i).next().equals(likeArray[j])){

       int idx = new Random().nextInt(likeArray.length);

       for(int i =0; i< likes.size(); i++){ //traverse through the linked list array
             if(likeArray[idx] != likes[i]){  // and check to see if this is a unique string.
                 System.out.println(likeArray[idx]);
                 break;
             }else{
                 idx = new Random().nextInt(likeArray.length); //pick another random string
             }
       }

    }//if