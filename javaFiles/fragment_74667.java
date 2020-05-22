Comparator comp;
if (getCurrentSortingMethod().equals("DateDescending")) {
   comp = new DateDescendingComparator();
} else if (getCurrentSortingMethod().equals("DateAscending")) {
   comp = new DateAscendingComparator();
} ...

int index = Collections.binarySearch(getEmails(), email, comp);