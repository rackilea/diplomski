private ArrayList<ArrayList<String>> mainList = new ArrayList<>();

for (int i = 0; i < items.size(); i++) {
     ArrayList<String> list2 = new ArrayList<>();
     for (int j = 0; j < items.get(i).innerItem.size(); j++) {
          list2.add(items.get(i).innerItem.get(j).string);
     }
     mainList.add(list2);
}