private void pick_highest_value_here_and_display(ArrayList<Double> value) throws Exception {
    // TODO Auto-generated method stub
    double aa[]=value.stream().mapToDouble(v -> v.doubleValue()).toArray(); 
    double highest=Double.MIN_VALUE;
    int index=0;
    System.out.println(highest);
    for(int i=0;i<aa.length;i++)
    {
        if(aa[i]>highest)
        {
            index=i;
            highest=aa[i];
        }
    }
    System.out.println(highest);
    System.out.println(index); 
}