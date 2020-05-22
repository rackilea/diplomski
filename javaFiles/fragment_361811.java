public Value reduce(Machine environment) {
    if(left instanceof Reducible){
        return new Add(((Reducible)left).reduce(environment), right);
    }
    if(right instanceof Reducible){
        return new Add(left, ((Reducible)right).reduce(environment));
    }
    return new VNumber(((VNumber)left).getValue() + ((VNumber)right).getValue());
}