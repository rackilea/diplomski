static boolean checkEndCondition(char[][] table){
    return checkRows(table) && checkColumns(table);
}

static boolean isValidCharacter(char c){
    return c=='S' || c=='M' || c=='A' || c=='R' || c=='T';
}

static boolean checkRows(char[][] table){
    HashSet<Character> hashset = new HashSet<Character>();
    for(int y=0;y<table.length;y++){
        for(int x=0;x<table[0].length;x++){
            if(isValidCharacter(table[y][x]))
                hashset.add(table[y][x]);
            else
                return false;
        }
        if(hashset.size()!=5)
            return false;
        hashset.clear();
    }
    return true;
}