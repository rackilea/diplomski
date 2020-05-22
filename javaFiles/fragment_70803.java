BufferedReader br = new BufferedReader(new InputStreamReader(input, "ascii"));

    for (String line; null != (line = br.readLine()); )
    {
        if (line.startsWith("Accelerometer:"))
        {
            String[] split = line.split("[:,]");
            float x = Float.parseFloat(split[1]);
            float y = Float.parseFloat(split[2]);
            float z = Float.parseFloat(split[3]);
            // do somehting with the data.
            System.out.printf("%f,%f,%f\r\n",x,y,z);
        }
    }