if (chanceDir >= 0.5) {
   Dir = IRobot.AHEAD;
   Vir = IRobot.BEHIND;
   Hir = IRobot.AHEAD;
   Sir = IRobot.BEHIND;
} else { 
   Dir = IRobot.RIGHT;
   Vir = IRobot.LEFT;
   Hir = IRobot.LEFT;
   Sir = IRobot.RIGHT; 
}

if (oppchanceDir >= 0.5) {
   Dir = IRobot.BEHIND;
   Vir = IRobot.AHEAD;
   Hir = IRobot.BEHIND;
   Sir = IRobot.AHEAD; 
}else { 
   Dir = IRobot.LEFT; 
   Vir = IRobot.RIGHT;
   Hir = IRobot.RIGHT;
   Sir = IRobot.LEFT; 
}