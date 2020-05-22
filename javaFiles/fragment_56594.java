List<Image> images = new ArrayList<>();
// populate your list

// sort the list based on the goodMatches property
images.sort(new GoodMatchesComparator());

// sort the list based on the anotherProperty property
images.sort(new AnotherPropertyComparator());