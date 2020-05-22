//Note that this output loop will interchange the columns for rows but it works fine for demonstration
for (String[] col:data){
    for (String s:col){
        System.out.print("\t"+s);
    }
    System.out.println();
}