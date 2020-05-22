Iterator<Bullet> itr = bullets.iterator();
while(itr.hasNext()) {
    if(itr.next().xPosition > screenWidth - 10) {
        itr.remove(i);
    }
}