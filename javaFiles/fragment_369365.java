private strSet = false;

    public String getStr() {
        if(null == str && !strSet) {
            return "default";
        } else {
            return str;
        }
    }

    public void setStr(String str) {
        this.str = str;
        this.strSet = true;
    }