public class Option<X> {
    private final X value;
    private final String name;

    public String toString() {
         return name;
    }

    public X getValue() {
         return value;
    }

    public Option(X value, String name) {
         this.value=value;
         this.name=name;
    }
}

public static JOptionPane newContactOptionPane(Object message,
        Set<XmlContact> contacts) {
    Object[] contactPossibilities = new Object[contacts.size()];
    int index = 0;
    for (XmlContact contct : contacts) {
        contactPossibilities[index] = new Option<XmlContact>(contct, String.format("%s %s, %s",
                contct.get_Surname1(), contct.get_Surname2(),
                contct.get_Name()));
        index++;
    }
    JOptionPane optPane = new JOptionPane();
    JOptionPane.showInputDialog(optPane, message, "Seleccionar Contacto",
            JOptionPane.QUESTION_MESSAGE, null, contactPossibilities,
            contactPossibilities[0]);
    return optPane;
}