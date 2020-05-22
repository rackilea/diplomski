try{
    Scanner innFil=new Scanner(new File("/uio/hume/student-u77/makrist/Downloads/akronymer.txt"));

    while(innFil.hasNext()){
        for(int i=0; i<500; i++){
            String theReadLine = innFil.nextLine();
            innlesningsarray=theReadLine.split("\t");
            System.out.println(innlesningsarray[i]);
            System.out.println(theReadLine);
        }
        System.out.println("test");
    }
    System.out.println("Test2");

    } catch(Exception e){
        System.out.print(e.printStackTrace);
    }
}