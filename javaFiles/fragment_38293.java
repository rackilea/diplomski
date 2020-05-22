for(int j = 0; j<= 2; j++) {
    for (int i = 0; i <= ladrillos[j].length - 1; i++) {
        ladrillos[j][i] = ...
        width += ladrillos[j][i].width() + 10;
        canvas.drawRect(ladrillos[j][i], paint);
    }
    height+= ladrillos[j][0].height() + 10;
}