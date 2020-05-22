public String changeXY(String str) {

  // when to stop
  if (str.length() == 0){
    return str;
  }

  // handle the "special case" using an assumption we can solve str.substring(1)
  if (str.charAt(0) == 'x'){
    return 'y' + changeXY(str.substring(1));
  }
  // handle the "simple" case using an assumption we can solve str.substring(1)
  return str.charAt(0) + changeXY(str.substring(1));
}