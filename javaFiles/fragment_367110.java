String input = "";
String OUT = "";


try {
      input = java.net.URLDecoder.decode(input_row.CustomField16, "ASCII");

} catch (UnsupportedEncodingException e) {
      e.printStackTrace();
}

String[] pieces = input.split(";");

/*for(int a=0; a<pieces.length; a++)
      System.out.println("Piece "+a+"\n"+pieces[a]);*/



String[] allfields = pieces[0].split("\\|");

//System.out.println("num_full_rows="+num_full_rows);


int fieldnum=9;
int totalrows=1;
for (int i=0; i+8<allfields.length; i++) {

      String xrow = allfields[i];
      i++;
      for (int j=i; j<fieldnum*totalrows;j++){
            xrow=xrow+"\t"+allfields[j];
      }
      i+=fieldnum-2;

      totalrows++;
      OUT += (input_row.LoadTime + "\t"
                  + input_row.minutepart + "\t" + input_row.TXID
                  + "\t" + input_row.SessionString + "\t" + xrow + "\n");


}

output_row.BULK = OUT;