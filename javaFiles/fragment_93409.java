@Override
 public boolean checkRequired() {
    if (!isRequired() && getValue().isEmpty()) {
       warn("Field'" + getLabel().getObject() + "' is empty. We suggest to fill it.");
       return Boolean.TRUE;
    }
    return super.checkRequired();

 }