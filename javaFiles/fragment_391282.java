public int count(List<LocalDate> dateList, LocalDate today) {
    if (!dateList.contains(today)) { // today is not in the list, return 0
        return 0;
    }

    int count = 0;
    LocalDate prev = dateList.get(0); // get first date from list
    for (int i = 1; i < dateList.size(); i++) {
        LocalDate next = dateList.get(i);
        if (prev.plusDays(1).equals(next)) {
            // difference between dates is one day
            count++;
        } else {
            // difference between dates is not 1
            // Do what? return 0? throw exception?
        }
        prev = next;
    }

    return count + 1; // didn't count the first element, adding 1
}