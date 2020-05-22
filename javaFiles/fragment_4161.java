private void whatYouDoInTheSwitch(Object object, some args) {
    if(object instanceof TypeA) {
        ((TypeA) object).doIt(this, some args);
    }
    else if(object instanceof TypeB) {
        ((TypeB) object).doIt(this, some args);
    }
}