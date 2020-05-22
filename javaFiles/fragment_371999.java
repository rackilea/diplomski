public static void main(String[] args) {

            List<String> list = new ArrayList<String>();
            list.add("item2");
            list.add("item3");
            list.add("item1");
            list.add("item4");

            System.out.println("Before : " + list);
            removeItem(list);
            System.out.println("After : " + list);
        }

        public static void removeItem(List<String> items) {

            if (items == null) {

                // Handle the null list
                System.out.println("List is null");
            } else if (items.contains("item1") && items.contains("item2")) {

                //Shuffle the list, randomize the items and then remove `item1` or `item2` which ever appears earliest.
                Collections.shuffle(items);
// Modern approach
items.stream().filter(i->i.equals("item1") || i.equals("item2")).findAny().ifPresent(i->items.remove(i));
/*
                int removeIndex = 0;
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("item1") || items.get(i).equals("item2")) {
                        removeIndex = i;
                        break;
                    }
                }

                items.remove(removeIndex);
 */   
            } else if (items.isEmpty()) {

            } else {

            }