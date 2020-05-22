if (pause.save) {
        Formatter f;
        FileWriter fw;
        PrintWriter pw = null;

        File f2 = new File("docs/save.txt");

        FileReader r;
        BufferedReader r1;
        try{


            //f = new Formatter("docs/save.txt");

            f2.createNewFile();

            fw = new FileWriter(f2);
            pw = new PrintWriter(fw);


            pw.println(mapwidth);
            pw.println(mapheight);

            for(int i = 0; i < overview.s.toArray().length; i ++){
                pw.print(overview.s.get(i).getID());
                if ((i + 1) % 50 == 0) {
                    pw.println();
                }
            }



        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ERROR!!!");
        }finally{

            pw.close();
        }
    }