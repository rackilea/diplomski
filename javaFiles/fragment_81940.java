public boolean equals(Object obj) {
    if(obj == null || !(obj instanceof KGramPostingsEntry)) {
        return false;
    }
    KGramPostingsEntry other = (KGramPostingsEntry) obj;
    if(other.tokenID == this.tokenID) {
        return true;
    }
    return false;
}