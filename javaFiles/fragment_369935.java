private String[] getNamesOfList(List<? extends SuperInterface> list) {
      namesArray = new String[list.size()];
      for (int j = 0; j < list.size(); j++) {
          namesArray[j] = list.get(j).getName();
      }
      return namesArray;
}