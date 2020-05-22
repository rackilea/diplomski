String[] find(String m[], String c[], String catchStr){

    String comp = c[0];
    ArrayList<String> list = new ArrayList<String>();
    for(int i=0;i<m.length;i++){

        boolean flag = false;

        //comparing if the substring matches or not
        if(comp.equals(m[i])){
            flag = true;
            for(int j=0;j<c.length;j++){
                //you can use equalsIgnoreCase() if you want to compare the string 
                //ignoring the case
                if(!m[i+j].equals(c[j])){
                    flag = false;
                    break;
                }
            }

        }

        if(flag){
            list.add(catchStr);
            i = i + c.length-1;
        }else{
            list.add(m[i]);
        }

    }

    //converting result into String array
    String finalArr[] = list.toArray(new String[list.size()]);

    return finalArr;

}