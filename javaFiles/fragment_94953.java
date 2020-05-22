while (!proceed.equalsIgnoreCase("n") && (!proceed.equalsIgnoreCase("y"))) {
    System.out.println("Invalid response. Try again....");
    proceed = keyboard.nextLine();
}
if (proceed.equalsIgnoreCase("n")) {
    System.out.println("Come back next time, " + name + ".");
    System.exit(0);

} else if (proceed.equalsIgnoreCase("y")) {
    System.out.println("now we are going to pay, " + name + "." + sum);
    System.exit(0);
}