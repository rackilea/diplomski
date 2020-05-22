public int searchJunction(IRobot robot) {

    boolean foundJunction = false;

    Junction currentJunction = null;

    //Iterate through list until the end, or until correct junction is found.
    while (!foundJunction && junctionIterator.hasNext()) {
        currentJunction = junctionIterator.next();
        if ((((currentJunction.x)==(robot.getLocation().x))) && ((currentJunction.y)==(robot.getLocation().y))) {
            foundJunction = true;
        }
    }

    return currentJunction;
}