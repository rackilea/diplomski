s1 = br.readLine();
while(s1 != null) { 
    if(s1.trim().length() > 0) {
        myList.add(s1);
        st=st.concat(s1);   
        //System.out.println(s1);
    }
    s1 = br.readLine();
}