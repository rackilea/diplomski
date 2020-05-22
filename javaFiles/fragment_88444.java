public void Generate(int numberOfGames){
    for (int i = 0; i < numberOfGames; i++){
        Numbers();
        Lottery = new ArrayList<Integer>();
        for(int x = 0; x < 6; x++){
            Lottery.add(Numbers.get(x));                
        }
        Collections.sort(Lottery);
        Games.add(Lottery);
    }
}