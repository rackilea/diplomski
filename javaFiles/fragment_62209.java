synchronized(dustList){
        Iterator<SpaceDust> it = dustList.iterator();

        while (it.hasNext() {
           SpaceDust sd = it.next();
           sd.update(player.getSpeed());
        }
}