for(i = 0 ; i < stringList.size(); i++){
     if(stringList.get(i).equals(resortsList.get(position).get(TAG_NAME))){
          stringList.remove(i);
          Log.d("String List: ", stringList.toString());
          break;
          }
 }`