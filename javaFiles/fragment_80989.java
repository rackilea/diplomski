@Override  
    public boolean equals(Object obj) {  
        if (obj == null) { return false; }  
        if (getClass() != obj.getClass()) { return false; }  
        if (! super.equals(obj)) return false;
        else {
           // compare subclass fields
        }