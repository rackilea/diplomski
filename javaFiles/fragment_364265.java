public boolean equals(Object obj){

    if (!obj instanceof Recipe) return false;
    if (obj == this) return true;

    Recipe tempRec = (Recipe) obj;

    for(int j = 0 ; j < Ingredients.length ; j++) {
        if(!Ingredients[j].equals(tempRec.Ingredients[j])) {
            return false;
        }
    }

    return true;
}