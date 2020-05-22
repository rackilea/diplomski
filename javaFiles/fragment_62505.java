writer=new PrintWriter(new FileWriter(file,true));
    for(int i=1;i<=60;i++){
        if(temp.contains(i)){
            writer.println(i+"   +++++++++++++++++   N");
        }
        else{
            writer.println(i+"   ---   Y");
    }
}