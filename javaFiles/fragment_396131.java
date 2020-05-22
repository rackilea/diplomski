class Salary {
    String names;
    Double amount;
    private String sortedNames = null;

    @Override
    public boolean equals(Object o)
    {
        if (o == null || ! (o instanceof Salary)) return false;
        Salary othr = (Salary) o;
        String thisNames = this.getSortedNames();
        String othrNames = othr.getSortedNames();
        return thisNames.equals(othrNames);
    }

    @Override 
    public int hashCode()
    {
        return getSortedNames().hashCode();
    }

    public String getSortedNames()
    {
        if (this.sortedNames == null)
        {
            String[] nameArr = this.names.split(",");
            Arrays.sort(nameArr);
            StringBuilder buf = new StringBuilder();
            for (String n : nameArr)
                buf.append(",").append(n);
            this.sortedNames = buf.substring(buf.length()==0?0:1);
        }

        return this.sortedNames; 
    }
}