while ((line=reader.readLine()) !=null) {            
        //Add to ArrayList
        demo.add(line);            
    }
    reader.close();
    //do fun stuff with the demo ArrayList here
    for (String s : demo) { System.out.println(s); }