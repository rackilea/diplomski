List<String> l = new ArrayList<String>(Arrays.asList(ss)){;
    @Override
    public String toString(){
        Iterator<String> it = iterator();
        if (! it.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (;;) {
            i++;
            String e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.toString();
            sb.append('\t');
            if (i%4==0){
                sb.append("\n");
            }
        }
    }
};
System.out.println(l);