public void setParameter(Parameter p) {
    setParameter((ConcreteParameter) p);
}

public Parameter getParameter() {
    return getParameter(); // calls the 'real' one!
}