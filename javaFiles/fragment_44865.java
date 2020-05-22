public int compareTo(Athlete other){
    int result = super.compareTo((Human)other);

    if(result == 0){
        return this.year - other.year;
    }

    return result;
}