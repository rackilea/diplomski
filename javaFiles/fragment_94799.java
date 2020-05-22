private void viewAvailableRoomDate(Date tempStart, Date tempEnd) {

    LinkedList<Integer> roomNbrs = new LinkedList<>();

    for (Booking b : books) {

        if ((!(tempStart.after(b.getCheckinDate()) && tempEnd.after(b.getCheckinDate())) ||
                (tempStart.before(b.getCheckoutDate()) && tempEnd.after(b.getCheckoutDate())) ||
                (tempStart.before(b.getCheckinDate()) && tempEnd.after(b.getCheckoutDate()))) ||
                (tempStart.after(b.getCheckinDate()) && tempEnd.before(b.getCheckoutDate()))){
            roomNbrs.add(b.getRoomNbr());
        }
    }