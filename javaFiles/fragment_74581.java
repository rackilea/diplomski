private void updateMissiles () {
    ArrayList ms = craft.getMissiles();
    int mLeft = enemyCraft.getX(); // guessing position is an int . Set the correct type when you copy this
    int mTop = enemyCraft.getY();
    int mRight = mLeft + 20;
    int mBottom = mTop + 20;

    for (int i = 0; i < ms.size(); i++) {
        Missile m = (Missile) ms.get(i);
        // only test if both missile and enemyCraft are visible
        // I am guessing that enemyCraft has a isVisible method
        if(m.isVisible() && enemyCraft.isVisible()){
            int mx = m.getX(); // Again I am guessing the type as int
            int my = m.getY();
            if ( ! (my > mBottom || mx > mRight || mx + 8 < mLeft || my + 5 < mTop)) {
                enemyCraft.explode();
                ms.remove(i);  // remove missile
            }
        }
        if (m.isVisible()) {
            m.move();
        }
    }
}