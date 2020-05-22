while (sc.hasNextLine()) {
    String line = sc.nextLine();
    count++;
    total += line.length();
    System.out.println(count + " " + line);
}