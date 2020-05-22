public boolean randomExist() {
    return list.size()>0;
}

public int getRandom() {
    int randomNumber = random.nextInt(list.size());
    return list.remove(randomNumber);
}