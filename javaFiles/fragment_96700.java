@Override
    public int compare(Object o1, Object o2) {
        Option op1=(Option) o1;
        Option op2=(Option) o2;
        return Integer.compare(optionKeys.indexOf(op1.getLongOpt()), optionKeys.indexOf(op1.getLongOpt()));
    }