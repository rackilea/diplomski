public void highlightMonsters(){
    while (mStack.size()!=0){ 
      String monsterString = mStack.pop().toString();
        switch(monsterString) 
case "1" : {
            monsterTopLeft.setVisible(!visibility);
            monsterTopLeftColored.setVisible(visibility);
            monsterTopLeftColored.registerUpdateHandler(changeColorsMonster1);
            monsterTopLeft.registerUpdateHandler(cakaj);
            break;
        }
case "2" :  {
            monsterTopRight.setVisible(!visibility);
            monsterTopRightColored.setVisible(visibility);
            monsterTopRightColored.registerUpdateHandler(changeColorsMonster2);
            monsterTopRight.registerUpdateHandler(cakaj);
            break;
        }
case "3" :  {
            monsterBottomLeft.setVisible(!visibility);
            monsterBottomLeftColored.setVisible(visibility);
            monsterBottomLeftColored.registerUpdateHandler(changeColorsMonster3);
            monsterBottomLeft.registerUpdateHandler(cakaj);
            break;
        }
case "4" : (mStack.peek().toString().equals("4")){
            monsterBottomRight.setVisible(!visibility);
            monsterBottomRightColored.setVisible(visibility);
            monsterBottomRightColored.registerUpdateHandler(changeColorsMonster4);
            monsterBottomRight.registerUpdateHandler(cakaj);
            break;
        }
default : break;
    }  
  mReverseStack.push(monsterString);
  } 
}