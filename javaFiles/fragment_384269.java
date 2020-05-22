public static void main(String[] args) throws ClassNotFoundException
    {
        PatientList<Patient> list = new PatientList<Patient>();
        try {
            File f = new File("Patients.txt");
            FileReader r = new FileReader(f);
            BufferedReader reader = new BufferedReader(r);

            String line = null;
            Patient patient = new Patient(); // create Object use the constructor that I added.
            int i = 1; // this variable is used to know on which line the reader is on
            while((line = reader.readLine()) != null)  
            {
               if(line.trim().equals("")) // if the line is a new line then add the previous patient to the list and create a new patient, re initialize i = 0
               {
                    list.add(patient);
                    patient = new Patient();
                    i = 1;
               }
               else
               {
                    if(i == 1) // on first line of the file set the patients name
                    {
                        patient.set_name(line);
                    }
                    else if(i == 2)//on second line of the file set the patients ID Number
                    {
                        patient.set_patientIDNumber(line);
                    }
                    // add else if for other attributes on other lines
                    i++;
               }    
            }
             list.add(patient);

             reader.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }