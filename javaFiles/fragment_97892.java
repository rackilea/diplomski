public class CsvReader {

    Reader r;
    int row, col;
    boolean endOfRow;

    public CsvReader(Reader r){
        this.r = r instanceof BufferedReader ? r : new BufferedReader(r);
        this.row = -1;
        this.col = 0;
        this.endOfRow = true;
    }

    /**
     * Returns the next string in the input stream, or null when no input is left
     * @return
     * @throws IOException  
     */
    public String next() throws IOException {
        int i = r.read();
        if(i == -1)
            return null;

        if(this.endOfRow){
            this.row++;
            this.col = 0;
            this.endOfRow = false;
        } else {
            this.col++;
        }

        StringBuilder b = new StringBuilder();
outerLoop:  
        while(true){
            char c = (char) i;
            if(i == -1)
                break;
            if(c == ','){
                break;
            } else if(c == '\n'){
                endOfRow = true;
                break;
            } else if(c == '\\'){
                i = r.read();
                if(i == -1){
                    break;
                } else {
                    b.append((char)i);
                }
            } else if(c == '"'){
                while(true){
                    i = r.read();

                    if(i == -1){
                        break outerLoop;
                    }
                    c = (char)i;
                    if(c == '\\'){
                        i = r.read();
                        if(i == -1){
                            break outerLoop;
                        } else {
                            b.append((char)i);
                        }
                    } else if(c == '"'){
                        r.mark(2);
                        i = r.read();
                        if(i == '"'){
                            b.append('"');
                        } else {
                            r.reset();
                            break;
                        }
                    } else {
                        b.append(c);
                    }
                }
            } else {
                b.append(c);
            }
            i = r.read();
        }

        return b.toString().trim();
    }


    public int getColNum(){
        return col;
    }

    public int getRowNum(){
        return row;
    }

    public static void main(String[] args){

        try {
            String input = "apple,boy,cat,\"dog,cat\",\"time\\\" after\\\"noon\"\nquick\"fix\" hello, \"\"\"who's there?\"";
            System.out.println(input);
            Reader r = new StringReader(input);
            CsvReader csv = new CsvReader(r);
            String s;
            while((s = csv.next()) != null){
                System.out.println("R" + csv.getRowNum() + "C" + csv.getColNum() + ": " + s);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}