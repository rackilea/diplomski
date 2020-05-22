while((line = br.readLine()) != null){
    System.out.println();
    jTextArea1.append("\n");

    for (String retval: line.split(" ", 0)){
        jTextArea2.append("\n");
        jTextArea2.append(retval);
        System.out.println();
        System.out.println(retval);
    }
}