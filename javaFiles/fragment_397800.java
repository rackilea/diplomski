readLoop:
while((strLine=br.readLine())!=null){

    // ...
    String[] splitVals = strLine.split(":");

    if((name.equals(nameUser))&&(pwd.equals(passWord))){
        System.out.println("welcome"+name);
        break readLoop;
    }

    // ...
}