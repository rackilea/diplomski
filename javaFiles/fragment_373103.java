public bool isWriteable(String s){
    if (this.x == null){
        return s.contains(this.ch);
    }
    else {
        return this.x.isWriteable(s) & s.contains(this.ch);
    }
}