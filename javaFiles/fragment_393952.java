for(int x = 0; x < 250; x++)
{
    BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
    out.write( randomNum() + System.getProperty("line.separator"));
}

out.close();