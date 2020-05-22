String facingDirection = robot.getFacing();

if (changeX != 0){
    System.out.println("x changed");

    if(changeX<0 && (facingDirection == 'N' || facingDirection == 'W')) {
        robot.checkDirection('L','W');
    }else if(changeX<0 && (facingDirection == 'S' || facingDirection == 'E')) {
        robot.checkDirection('R','W');
    }else if (changeX>0 && (facingDirection == 'S' || facingDirection == 'E')) {
        robot.checkDirection('L','E');
    }else{
        robot.checkDirection('R', 'E');
    }
} else {
    System.out.println("y changed");

    if(changeY<0 && (facingDirection== 'N' || facingDirection== 'W')) {
        robot.checkDirection('L','S');
    }else if(changeY<0 && (facingDirection== 'E' || facingDirection== 'S')) {
        robot.checkDirection('R','S');
    }else if (changeY>0 && (facingDirection== 'S' || facingDirection== 'E')) {
        robot.checkDirection('L','N');
    }else{
        robot.checkDirection('R','N');
    }
}