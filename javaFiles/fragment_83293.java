@Override
public boolean equals(Object object){
    if(object == null || object.getClass() != this.getClass()){
        return false;
    }

    State other = (State)object;
    return this.state.equals(other.state);
}