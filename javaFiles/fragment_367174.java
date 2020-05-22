private void accumulate(ArrayList<String> list, String string) {
        if (list.isEmpty() || list.get(list.size() -1).length() + string.length() > MAXIMUM_CHARACTERS){
            list.add(string);
        } else {
            list.set(list.size()-1, list.get(list.size()-1) + string);
        }
    }