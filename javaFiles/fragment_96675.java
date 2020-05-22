String[] qrList = results.getContent().toString().split("\\,");

for(int count = 0; count < qrList.length; count++) {
  //each index represents the split string e.g
  // [0] == "aa"
  // [1] == "bb"
  // [2] == "cc"
  // [3] == "dd"
  // [4] == "ee"
  if (count == 0){
     strA.add(qrList[count]);
  } else if (count == 1){
     strB.add(qrList[count]);
  } else if (count == 2 || count == 3){
     strCD.add(qrList[count]);
  } else if (count == 4){
     strE.add(qrList[count]);
  }
}