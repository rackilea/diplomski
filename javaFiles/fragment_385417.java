Scanner sc = new Scanner(inputStr);

while (sc.hasNextLine()) {
    String line = sc.nextLine();
    String parts[] = line.split(",");
    String time[] = parts[0].split(":");
    String phone[] = parts[1].split("-");
    // Process the time and phone number here
}