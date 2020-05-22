import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class CharacterSwapping {
    public static void main(String args[]) {
        ArrayList<Character> orgnlAlphabets = new ArrayList<Character> ();
        orgnlAlphabets.add('A');
        orgnlAlphabets.add('B');
        orgnlAlphabets.add('C');
        orgnlAlphabets.add('D');
        orgnlAlphabets.add('E');
        orgnlAlphabets.add('F');
        orgnlAlphabets.add('G');
        orgnlAlphabets.add('H');
        orgnlAlphabets.add('I');
        orgnlAlphabets.add('J');
        orgnlAlphabets.add('K');
        orgnlAlphabets.add('L');
        orgnlAlphabets.add('M');
        orgnlAlphabets.add('N');
        orgnlAlphabets.add('O');
        orgnlAlphabets.add('P');
        orgnlAlphabets.add('Q');
        orgnlAlphabets.add('R');
        orgnlAlphabets.add('S');
        orgnlAlphabets.add('T');
        orgnlAlphabets.add('U');
        orgnlAlphabets.add('V');
        orgnlAlphabets.add('W');
        orgnlAlphabets.add('X');
        orgnlAlphabets.add('Y');
        orgnlAlphabets.add('Z');
        orgnlAlphabets.add('a');
        orgnlAlphabets.add('b');
        orgnlAlphabets.add('c');
        orgnlAlphabets.add('d');
        orgnlAlphabets.add('e');
        orgnlAlphabets.add('f');
        orgnlAlphabets.add('g');
        orgnlAlphabets.add('h');
        orgnlAlphabets.add('i');
        orgnlAlphabets.add('j');
        orgnlAlphabets.add('k');
        orgnlAlphabets.add('l');
        orgnlAlphabets.add('m');
        orgnlAlphabets.add('n');
        orgnlAlphabets.add('o');
        orgnlAlphabets.add('p');
        orgnlAlphabets.add('q');
        orgnlAlphabets.add('r');
        orgnlAlphabets.add('s');
        orgnlAlphabets.add('t');
        orgnlAlphabets.add('u');
        orgnlAlphabets.add('v');
        orgnlAlphabets.add('w');
        orgnlAlphabets.add('x');
        orgnlAlphabets.add('y');
        orgnlAlphabets.add('z');
        ArrayList<Character> swappedAlphabets = new ArrayList<Character> ();
        swappedAlphabets.addAll(orgnlAlphabets);

        try {
            //BufferedReader br = new BufferedReader(new FileReader("/tmp/characterswapping_input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> inputs = new ArrayList<String> ();
            String sCurrentLine;
            int glbLineCnt = 0;
            while ((sCurrentLine = br.readLine()) != null && !"".equals(sCurrentLine.trim())) {
                inputs.add(sCurrentLine.trim());
            }
            glbLineCnt = 0;
            sCurrentLine = inputs.get(glbLineCnt++);            
            int noOfSwapes = Integer.parseInt(sCurrentLine);
            while (noOfSwapes > 0) {
                sCurrentLine = inputs.get(glbLineCnt++);
                String firstLine[] = sCurrentLine.split(" ");
                int firstCharIndex = swappedAlphabets.indexOf(firstLine[0].charAt(0));
                int secondCharIndex = swappedAlphabets.indexOf(firstLine[1].charAt(0));
                swappedAlphabets.set(firstCharIndex, firstLine[1].charAt(0));
                swappedAlphabets.set(secondCharIndex, firstLine[0].charAt(0));
                noOfSwapes--;
            }
            sCurrentLine = inputs.get(glbLineCnt++);
            Character currentChar, orgnlChar;
            for (int i = 0; i < sCurrentLine.length(); i++) {
                currentChar = sCurrentLine.charAt(i);
                if (" ".equals(currentChar.toString())) {
                    System.out.print(" ");
                } else {
                    orgnlChar = orgnlAlphabets.get(swappedAlphabets.indexOf(currentChar));
                    System.out.print(orgnlChar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}