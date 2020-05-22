CSVReader reader = new CSVReader(new FileReader(<filepath>));

String[] temp;
int NUM = #; //number of rows in csv, or insert code to read through file until null.

for(int i = 0; i < NUM; i++)
{               
    temp = reader.readNext();               //read next line into temp
}

System.out.println(temp[0]); //Acton Town (District)
System.out.println(temp[1]); //Acton Town (Piccadilly)
System.out.println(temp[2]); //2.00 (string)


reader.close();