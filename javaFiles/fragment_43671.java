import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Principal {

    private static final String IN = "C:\\Users\\CD\\Downloads\\dummydata.csv";
    private static final String OUT = "C:\\Users\\CD\\Downloads\\result.txt";

    public static List<Personas> readFile(final String file) throws Exception {
        final List<Personas> result = new ArrayList<Personas>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String texto = "";
            while ((texto = reader.readLine()) != null) {
                final String[] valores = texto.split(",");
                final Personas persona = new Personas(valores[0], valores[1], valores[2], valores[3]);
                result.add(persona);
            }
        }
        return result;
    }

    public static void write(final String file, final List<Personas> personas) throws Exception {
        new File(file);
        try (PrintWriter wr = new PrintWriter(new File(file))) {
            for (final Personas persona : personas) {
                wr.write(persona.getNombre() + "\t");
                wr.append(persona.getFechaNacimiento() + "\t");
                wr.append(persona.getDireccion() + "\t");
                wr.println(persona.getEmail());
            }
        }
    }

    public static void main(final String[] args) throws Exception {
        final List<String> emailsToRemove = Arrays.asList("email1@lol.com", "email2@lol.com");

        final List<Personas> personas = readFile(IN);

        //Remove some personnas
        for (Iterator<Personas> it = personas.iterator(); it.hasNext(); /**RIEN**/) {
            Personas act = it.next();
            if(emailsToRemove.contains(act.getEmail())){
                it.remove();
            }
        }

        write(OUT, personas);
    }
}