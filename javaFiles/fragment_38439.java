List<Survivor> toRemove = new ArrayList<Survivor>();
    List<Zombie> toAdd = new ArrayList<Zombie>();

    Iterator<Survivor> survIt = survivors.iterator();
    Iterator<Zombie> zombIt = zombies.iterator();
    while (survIt.hasNext()) {
        Survivor s = survIt.next();
        while (zombIt.hasNext()) {
            Zombie z = zombIt.next();
            if (z.bounds.intersects(s.bounds)){
                toAdd.add(new Zombie(s.position, this));
                toRemove.add(s);
                System.out.println("collided");
            }
        }
    }

    for (Survivor s : toRemove) {
        survivors.remove(s);
    }

    for (Zombie z : toAdd) {
        zombies.add(z);
    }