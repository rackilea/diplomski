if (chanceDir >= 0.5 && ((Dir == IRobot.AHEAD) && (Vir == IRobot.BEHIND) && (Hir == IRobot.AHEAD) && (Sir == IRobot.BEHIND))) {
  // do something here

}else if((Dir == IRobot.RIGHT) && (Vir == IRobot.LEFT) && (Hir == IRobot.LEFT) && (Sir == IRobot.RIGHT)){
  // do something here
}else{
  // do something here
}

if (oppchanceDir >= 0.5 && ((Dir == IRobot.BEHIND) && (Vir == IRobot.AHEAD) && (Hir == IRobot.BEHIND) && (Sir == IRobot.AHEAD))) {
  // do something here

} else if ((Dir == IRobot.LEFT) && (Vir == IRobot.RIGHT) && (Hir == IRobot.RIGHT) && (Sir == IRobot.LEFT)) {  
  // do something here
}else{
  // do something here
}