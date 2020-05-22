import java.io.*;
    import employee.*;

    public class ClearTechSolutions {
        public static void main(String[] args) {
            ContractEmployee[] con = new ContractEmployee[3];
            PermanentEmployee[] per = new PermanentEmployee[3];

            for(int i=0;i<3;i++) {
                con[i] = new ContractEmployee();
                per[i] = new PermanentEmployee();
            }

            con[0].setData( "C001", "Mohan", "E-32 M.G Marg", "30/Jun/1974", 0.0f, 1000.0f, 0.0f,     5000.0f, 20, 7);
            con[1].setData( "C002", "Steve", "A-32 M.G. Marg", "15/Oct/1981", 0.0f, 1500.0f, 0.0f,     7500.0f, 22, 3);
            con[2].setData( "C003", "Mary", "A-31 Rohini", "15/Dec/1979", 0.0f, 2500.0f, 0.0f, 10000.0f,     18, 5);
            per[0].setData( "E001", "Bob", "E-12 Lajpat Nagar", "01/Feb/1974", 0.0f, 20000.0f, 0.0f,     800000.0f, 7, 28);
            per[1].setData( "E002", "Kevin", "E-15 Mandir Marg", "01/Apr/1990", 0.0f, 25000.0f, 0.0f,     1000000.0f, 6, 26);
            per[2].setData( "E003", "Mohan", "E-15 Mandir marg", "31/July/1984",0.0f, 10000.0f, 0.0f,     400000.0f,9,30);
            con[0].calc(1000.0f);
            con[1].calc(1500.0f);
            con[2].calc(2500.0f);
            per[0].calc(20000.0f);
            per[1].calc(25000.0f);
            per[2].calc(10000.0f);

            try {
                File file = new File("emplo.dat");
                file.createNewFile();
                FileOutputStream fi = new FileOutputStream(file);
                ObjectOutputStream obj = new ObjectOutputStream(fi);

                for(int i=0;i<3;i++) {
                    System.out.println("\n");
                    System.out.println("The details for Contract Employee "+(i+1)+" are:");
                    con[i].print();
obj.writeObject(con[i]);                <-- this will write your object to file connected to file output stream.
                }
                for(int i=0;i<3;i++) {
                    System.out.println("\n");
                    System.out.println("The details for Permanent Employee "+(i+1)+" are:");
                    per[i].print();
obj.writeObj(per[i]);
                }
            }
            catch(IOException e) {}
        }
    }