public class Foo {

    File T_file;

    public static void main (){
        new Foo("file_name");
    }

    Foo(String fileName)
    {

        T_file = new File (fileName);        

        StatusListener listener = new StatusListener(){     
            public void onStatus(Status status){
                if (Foo.this.T_file.length() > 100){
                    System.out.println ("I have access here");
                  }
            }
        };
    }
}