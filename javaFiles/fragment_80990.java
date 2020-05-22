@Override     
    public int hashCode() {     
        int hash = super.hashCode();
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);     
        hash = 89 * hash + (this.faceBookNickname != null ? this.faceBookNickname.hashCode() : 0);     
        return hash;     
    }