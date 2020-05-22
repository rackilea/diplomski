for(int x = 0; x < (front.length); x++){
    for(int y = 0; y < (back.length); y++){
        int temp = front[y];

        if (front[x] - back[y] <= front[x] && front[x] - back[y]  >= 0 ) {
            hiddenAt.add(temp);
        }

    }
}