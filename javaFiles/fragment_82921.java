public Integer value(State s){
    switch (operation) {
        case Add:
            return leftoperand.value(s) + rightoperand.value(s);
        case Sub:
            return leftoperand.value(s) - rightoperand.value(s);
        case Mul:
            return leftoperand.value(s) * rightoperand.value(s);
        case Div:
            return leftoperand.value(s) / rightoperand.value(s);
        case Rem:
            return leftoperand.value(s) % rightoperand.value(s);
    }
}