while (true) {
    System.out.println("Type another number to continue or type 'End' to end");
    end = scan.next();
    if ("end".equalsIgnoreCase(end)) break;
    // now do your stuff
    num2 = Integer.parseInt(end);
    // ...
}