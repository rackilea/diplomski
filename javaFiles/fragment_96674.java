for(int count=0; count < resultToString.size(); count++) {
  //separate string to array list
  if (count == 0){
     strA.add(resultToString.get(count));
  } else if (count == 1){
     strB.add(resultToString.get(count));
  } else if (count == 2 || count == 3){
     strCD.add(resultToString.get(count));
  } else if (count == 4){
     strE.add(resultToString.get(count));
  }
}