public static void removeDuplicates(ArrayList<Integer> list, int counter){


        if(list == null){
            throw new NullPointerException();
        }

        if(counter < list.size()){
            if(list.contains(list.get(counter))){
                if(list.lastIndexOf(list.get(counter))!=counter)
                {
                    list.remove(list.lastIndexOf(list.get(counter)));
                    counter--;
                }
            }
            removeDuplicates(list, ++counter);
        }

    }