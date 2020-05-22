import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
public class TestApplication {
    public static void main(String[] args) throws IOException {
    System.out.println("hi");
        PacienteParser paciente = new PacienteParser();
        CSVFile<Paciente> file = new CSVFile<>();
        file.open("pacientes.csv");
        file.setParser(paciente);
        List<Paciente> pList =file.readObject();
    for(Paciente p:pList){
        System.out.println(p.getNome());
        System.out.println(p.getRg());
        System.out.println(p.getDataNascimento());
    }
        file.close();
    }
}



class Paciente {
    private String nome;
    private String rg;
    private String dataNascimento;
    public Paciente(String nome, String rg, String dataNascimento) {
        super();
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public Paciente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}





class PacienteParser implements CSVParser<Paciente> {
    @SuppressWarnings("resource")
    public Paciente parseObjects(String dados) {
    Paciente paciente=new Paciente();
    String[] as=dados.split(";");
        paciente.setNome(as[0]);
        paciente.setRg(as[1]);
        paciente.setDataNascimento(as[2]);
          return paciente;
    }
}




 interface CSVParser<T> {
    public T parseObjects(String dados);
}


 class CSVFile<T> {
    private CSVParser<T> objectParser;
    BufferedReader reader ;

    @SuppressWarnings("resource")
    public void open(String filename) {
        try {
            reader =new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        }
    }

    public void close() throws IOException {
        reader.close();
    }

    public List<T> readObject() {
        List<T> list=new ArrayList<>();
        String line="";
        try{
            while ((line = reader.readLine()) != null) {

               T t=(T) objectParser.parseObjects(line);
                list.add(t);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return list;
    }

    public void setParser(CSVParser<T> parser) {
        this.objectParser = parser;
    }

}