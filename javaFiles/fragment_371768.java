public void loadBookings() {

    String bookings = FileIO.readTextFile("bookings.txt");
    //GregorianCalendar cal1;
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    int counter = 0;
    String[] bookList = bookings.split(",");

    for (String element : bookList) {
        counter++;
        System.out.println("Element to be persed:" + element);

        if (counter == 1) {
            tableNumbers.add(Integer.parseInt(element.trim()));
        } else if (counter == 2) {
            names.add(element);
        } else if (counter == 3) {
            surnames.add(element);
        } else if (counter == 4) {
            contacts.add(element);
        } else if (counter == 5) {
            dates.add(element);
        } else if (counter == 6 || counter == 7) {

            if (element.contains("\n")) {
                String thisLineLastElement = "";
                String nextLineFirstElement = "";

                if (element.endsWith("\n")) {
                    thisLineLastElement = element.trim();
                } else {
                    String[] split = element.split("\n");
                    thisLineLastElement = split[0];
                    nextLineFirstElement = split[1];
                }

                if (counter == 6) {
                    quantities.add(Integer.parseInt(thisLineLastElement.trim()));
                    comments.add("N/a");

                } else if (counter == 7) {
                    comments.add(thisLineLastElement);
                }
                if (!element.endsWith("\n")) {
                    tableNumbers.add(Integer.parseInt(nextLineFirstElement.trim()));
                }
                counter = 1;
            }

            if (counter == 6) {
                quantities.add(Integer.parseInt(element.trim()));
            }

        }

    }
}