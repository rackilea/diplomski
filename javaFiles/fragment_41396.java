public class ExcuteStringCode {

/**
 * @param args
 * @throws IOException 
 */
public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    try {
        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_21");
        BufferedReader br=new BufferedReader(new FileReader("d:\\example.txt"));
        PrintWriter writer=new PrintWriter("d:\\Test.java");
        writer.write("public class Test{\n");
        writer.write("public static void excute(){\n");
        String reader="";
        System.out.println("start");
        while((reader=(br.readLine()))!=null){
            writer.write(reader+"\n");
        }
        writer.write("}\n}");

        br.close();
        writer.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler);
        int b=compiler.run(null, null, null,"d:\\Test.java");
        Test testme=new Test();
        testme.excute();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}