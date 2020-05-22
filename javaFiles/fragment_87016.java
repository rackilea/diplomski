for(int i = 0; i < gameList.size(); i++) {
    if(gameList.get(i).getName().contains(query)) {
        temp.add(gameList.get(i));
    }
}
return temp;