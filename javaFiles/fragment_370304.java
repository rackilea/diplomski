public ArrayList<Worker> listOfWorkers()
{


    List<Worker> list=new ArrayList<Worker>();

    try
    {

        File ifile = new File("worker.txt");
        Scanner scan = new Scanner(ifile);
        while (scan.hasNextLine())
        {
             // no change
            if (jobType == Jobs.ELECTRICAL_ENGINEER || jobType == Jobs.MECHANICAL_ENGINEER)
            {
               // no change
                Worker eng = new Engineer(name,social,years,jobType,weeklyBen);
                list.add(eng);
            }
            else if()
            {
              //do same as above for other workers
            }
        }
        return list;
}