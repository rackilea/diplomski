for (int j = 0; j < all.size();) {

    PhysicalActivity p = all.get(j);
    DateTime when = new DateTime(p.getTimestamp());

    if (when.isAfter(start) && when.isBefore(stop)) {
        tempList.add(p);
        all.remove(j); //remove the matching object from the list
    } else {
        j++;
    }
}