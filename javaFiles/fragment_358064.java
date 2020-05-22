if (androidVersion.getApi().toLowerCase().contains(charString) ||
    androidVersion.getName().toLowerCase().contains(charString) ||
    androidVersion.getVer().toLowerCase().contains(charString)) {

    filteredList.add(androidVersion);
   }