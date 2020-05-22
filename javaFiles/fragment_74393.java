@Override
    public boolean equals(Object o){
        if (o instanceof Pop) {
            return equals((Pop)o);  
            // this equals will be the one below, because of overload resolution
        }
        System.out.print("O");
        return false;
    }