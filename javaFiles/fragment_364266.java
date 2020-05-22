public boolean equals(Object obj){

    if (!obj instanceof Recipe) return false;
    if (obj == this) return true;

    Recipe tempRec = (Recipe) obj;
    return Arrays.equals(this.Ingredients, tempRec.Ingredients);
}