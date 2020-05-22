//number of fields of Sudoku
public final static int NUM_FIELDS = 81;
//ascii value for zero
public final static int ASCII_ZERO = 48;

//Sudoku figures to be entered by GUI user
private final JTextArea field;

[...]

//code to retrieve input
byte[] bytes = field.getText().getBytes();
int[] figures = new int[NUM_FIELDS];

for (int c = 0, i = 0; c < bytes.length; c++) {
    if (bytes[c]>=ASCII_ZERO && bytes[c]<(ASCII_ZERO+10)) {
        figures[i++] = (bytes[c] - asciiNull); //store entered value as int in array
    }
    //ignore newline characters but optionally handle wrong input by user using else-statements    
}