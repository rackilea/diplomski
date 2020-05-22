String line1 = null;
while (input.hasNextLine()) {
    line1 = input.nextLine();
    if (input.hasNextLine()) {
        String line2 = input.nextLine();
        System.out.println(line2);
        System.out.println(line1);
        line1 = null;
    }
}
if (line1 != null)
    System.out.println(line1);