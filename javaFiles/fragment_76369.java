public String getMsg() {
    if (msg != null) {
        return msg;
    }
    ValueBinding vb = getValueBinding("msg");
    if (vb != null) {
        return (String) vb.getValue(getFacesContext());
    }
    return null;
}