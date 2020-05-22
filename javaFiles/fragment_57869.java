String input;
while(true) {
    input = costscan.nextLine();
    if(input.isEmpty()) {
        input = "0.08";
        break;
    }
    if(isParseable(input)) {
        break;
    }
    System.out.println("ENTER ONLY NUMBERS [DEFAULT 0.08]");
}
double costperkm = Double.parseDouble(input);