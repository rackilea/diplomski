Process process = Runtime.getRuntime().exec("CMD /C SYSTEMINFO | FINDSTR /B /C:\"System Type\"");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line = bufferedReader.readLine();
    if (line.indexOf("x64") > 0)
        System.out.println("x64 architecure");
    else
        System.out.println("x86 architecure");