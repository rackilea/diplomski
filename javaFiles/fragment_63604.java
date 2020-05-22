// untested!
abstract class Element {
    private char character;
    public char getChar() {
        return character;
    }
    Element(char c) {
        character = c;
    }
}

class Fantasma extends Element {
    Fantasma() {
        super('F');
    }
}

class Pared extends Element {
    Pared() {
        super('P');
    }
}

class Vacio extends Element {
    Vacio() {
        super(' ');
    }
}

public Element[][] readFile() throws FileNotFoundException {
    Scanner scan = new Scanner(new File("inicio.txt"));
    Element[][] res = new Element[10][10]; // insert your dimensions here
    while (scan.hasNext()) {
        String line = scan.next();
        if (line.equals("Pared") || line.equals("Fantasma")) {
            int i = scan.nextInt();
            int j = scan.nextInt();
            if(line.equals("Pared"))
                res[i][j] = new Pared();
            else
                res[i][j] = new Fantasma();
        }
    }
    // add spaces so we're not left with any null references
    for (int i = 0; i < res.length; i++)
        for (int j = 0; j < res[i].length; j++)
            if (res[i][j] == null)
                res[i][j] = new Vacio();
    return res;
}