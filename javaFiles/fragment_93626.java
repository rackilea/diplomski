public class Searchright {
    public static void main(String[] args) throws IOException {

    Scanner s = null;
    String str;

    try {
        s = new Scanner(new BufferedReader(new FileReader("doc.txt")));
     do{
        //while (s.hasNext()) {
             str=s.next();
            if((s.hasNext(("xxx"))||s.hasNext(("X.X.X”))))
           {
                    //System.out.println(s.next()+" "+s.next() );
                    //System.out.println(s.next());     
                    System.out.println(str);
                    //s.next();
                }

        //System.out.println(s.next());

        }while(s.hasNext());
    }

    finally{
        if (s != null) {
            //s.close();
        }
    }
}
}