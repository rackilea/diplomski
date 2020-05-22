public boolean equals(Object obj) {

    if (this == obj) { // if the references are the same, they must be equal
        return true;
    } else if (obj instanceof Player) { 

        Player player = (Player) obj; // we cast the reference

        if (player.getName().equals(this.getName())) { // we compare the name
            return true; // they are equal if names are equal
        } else {
            return false; // otherwise, they aren't 
        }
    } else {
        return false; // if the target object isn't of the type you want to compare, we choose to say it is not equal
    }
}