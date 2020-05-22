Process p = Runtime.getRuntime().exec
        (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
  BufferedReader input =
            new BufferedReader(new InputStreamReader(p.getInputStream()));
    while ((line = input.readLine()) != null) 
    {
        System.out.println(line);
    }