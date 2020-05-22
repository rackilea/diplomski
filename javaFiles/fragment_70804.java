Iterator<float[]> iterator = 
        new BufferedReader(new InputStreamReader(input, "ascii"))
            .lines()
            .filter(s -> s.startsWith("Accelerometer:"))
            .map(s -> s.split("[:,]"))
            .map(p -> new float[]{
                    Float.parseFloat(p[1]),
                    Float.parseFloat(p[2]),
                    Float.parseFloat(p[3]),
            }).iterator();

    while (iterator.hasNext())
    {
        float[] p = iterator.next();
        System.out.printf("%f,%f,%f\r\n", p[0], p[1], p[2]);
    }