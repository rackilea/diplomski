public static void main(String[] args) throws IOException {
    char[] input = new char[1000];
    int input_size = 0;
    int readChars;

    //Reader in = new InputStreamReader(System.in);
    Reader in = new FileReader("572be-stud3.txt");
    do {
        readChars = in.read(input);
        for (int a = 0; a < readChars; a++) {
            if (input[a] >= 48 && input[a] <= 57) {
                input_size++;
            }
        }
    } while((readChars < 0) || (input[readChars-1] != '\n'));
    in.close();

    System.out.println(input_size);
}