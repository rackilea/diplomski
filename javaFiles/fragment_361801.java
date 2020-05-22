@Override
protected void paintComponent(Graphics pen) {
    super.paintComponent(pen);
    for (int i = 0; i < pointList.size(); i++) {

        Dot p = pointList.get(i);
        p.draw(pen);

    }
}