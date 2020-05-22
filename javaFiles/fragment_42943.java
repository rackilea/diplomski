public static String readFile(InputStream is) throws IOException
{
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null)
        {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    }
}