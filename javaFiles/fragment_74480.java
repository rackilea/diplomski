boolean control = true;
while (control) {
    System.out.println("Add new values");
    String temp = in.next();
    if (temp.equals("bye"))
        control = false;
    else
        ciccio.addIt(temp);
}