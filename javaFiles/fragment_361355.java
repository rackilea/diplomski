String sortName;
if (lastName != null && lastName.length() > 0) {
   sortName = lastName;
} else {
   sortName = null;
}
sortOptions.setSortField(sortName);