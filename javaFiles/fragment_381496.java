while (objectIterator.hasNext()) {
        GameObject tmp = objectIterator.next();
        if (tmp.getHealth() < 1) {
            if (tmp.getClass() == Enemy.class) {
                enemyUnitCount --;
            }
            objectIterator.remove();          
        }
    }