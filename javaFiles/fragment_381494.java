while(objectIterator.hasNext())
    {
        if(objectIterator.next().getHealth() < 1)
        {
            if(objectIterator.next().getClass() == Enemy.class) 
                enemyUnitCount --;
            objectIterator.remove();          
        }
    }