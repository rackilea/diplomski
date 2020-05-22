Stack<Rock> stack = new Stack<Rock>();
stack.push(r1);
stack.push(r2);
stack.push(r3);
Iterator<Rock> iter = stack.iterator();
while(iter.hasNext()) {
    Rock r = iter.next();
    //do something with the current rock
}