public static void main(String[] args) {
    try {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("python scripts/doesnotexist.py");

        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
        String line = "";
        while((line = bfr.readLine()) != null)
            System.out.println(line);
    }
    catch(Exception e) {
        System.out.println(e.toString());
    }
}

// python: can't open file 'scripts/doesnotexist.py': [Errno 2] No such file or directory
// Process finished with exit code 0