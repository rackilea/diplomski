public static void main(String[] args) {

    ArrayList subList = new ArrayList();
    subList.add("1");
    subList.add("2");
    subList.add(null);
    subList.add(null);
    subList.add("3");

    for(int i=0;i<subList.size();i++)
        if(subList.get(i)!=null) {
            for(int j=0;j<i;j++) {
                if (subList.get(j)==null) {
                    Collections.swap(subList,i,j);
                    break;
                }
            }
        }
    }
}