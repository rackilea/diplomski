LinkedList<Bullet> bulletsToRemove = new LinkedList<>();
    for(Enemy e : enemies){         //collision : enemy & bullet
        for(Bullet b : bullets){
            if(b.getx()+bulletSize >= e.getx() && b.getx() <= e.getx()+20){
                if(b.gety()+bulletSize >= e.gety() && b.gety() <= e.gety()+20){
                    e.setHit();
                    bulletsToRemove.add(b);
                }
            }
        }
    }
    for(Bullet b : bulletsToRemove){ //Remove bullets from ArrayList 
        bullets.remove(b);
    }