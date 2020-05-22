public boolean addSeating(Group group) {
    Seating seating = createSeating(group);
    if (seating != null){
        seatings.add(seating);
        return true;
    }
    return false;
}