@Override
public boolean equals(Object obj){
    if (obj.Name.equals(this.Name) && obj.FilterID == this.FilterID)
        return true;
    else
        return false;
}