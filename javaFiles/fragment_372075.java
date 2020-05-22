public class hw2redo 
{
    public static void main(String args[])
    {
         //Scan file for data
         GeometricObject g = null;
         BufferedReader file = new BufferedReader(new FileReader("file.txt"));
            Scanner diskScanner = new Scanner(file);
            //Create dynamic array list
            List<GeometricObject> list = new ArrayList<GeometricObject>();
            //Scan data and add data to list
            while(diskScanner.hasNext())
            {
                String geolist = diskScanner.nextLine();
                g = recreateObject(geolist);

                list.add(g);

            }


    }

        private static GeometricObject recreateObject(String data)
        {
            System.out.println(data);
        }

}