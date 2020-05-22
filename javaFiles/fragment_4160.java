private void whatYouDoInTheSwitch(Object object, some args) {
    if(object instanceof TypeA) {
        this.doIt((TypeA) object, some args);
    }
    else if(object instanceof TypeB) {
        this.doIt((TypeB) object, some args);
    }
}