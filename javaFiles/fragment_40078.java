while (scanner.hasNextLine()) {
    String input = scanner.nextLine();

    if (input.equals("End")) {
        break;
    } else {
        try {
            int num = Integer.parseInt(input);
            list.add(num);

        } catch (NumberFormatException e) {
            System.out.println("Please Enter an Integer");
        }
    }
}