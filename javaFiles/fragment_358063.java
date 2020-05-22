if (charString.contains(",")) {
  String searchChar[] = charString.split(",");
  for (int i = 0; i < searchChar.length; i++) {

    if (androidVersion.getApi().toLowerCase().contains(searchChar[i]) || androidVersion
        .getName()
        .toLowerCase().contains(searchChar[i]) || androidVersion.getVer().toLowerCase()
        .contains(searchChar[i])) {

      filteredList.add(androidVersion);
    }
  }
} else {
  if (androidVersion.getApi().toLowerCase().contains(charString) || androidVersion.getName()
      .toLowerCase().contains(charString) || androidVersion.getVer().toLowerCase()
      .contains(charString)) {

    filteredList.add(androidVersion);
  }
}