@Override
public boolean equals(Object o){

    if (o instanceof Note) {
        Note target = (Note) o;
        if(this.name.equals(target.getName()) && this.friends.equals(target.getFriends())){
            return true;
        }
    }
    return false;
}