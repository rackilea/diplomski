System.out.print("Enter an integer number: ");
if (!in.hasNextLong()) {
    in.next();
    continue;
}
long i = in.nextLong();
System.out.print("Thanks, you entered: ");
System.out.println(i);
break;