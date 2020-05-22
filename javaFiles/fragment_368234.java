String[] col=col_name.split(",");
BufferedReader br = new BufferedReader(new FileReader("file.csv"));
String header = br.readLine();
if(header!=null)
{
    String[] two = header.split(",");
    System.out.println(header);
    int[] indices = new int[col.length];
    for(int j = 0; j < col.length; j++){
       indices[j]=Arrays.asList(two).indexOf(col[j]);
    }
    System.out.println(Arrays.toString(indices));
}