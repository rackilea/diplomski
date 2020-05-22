public static void main(String[] args) {
    try {
        File python = new File("scripts/script.py");
        System.out.println(python.exists()); // true

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("python scripts/script.py"); // print('Hello!')

        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null)
            System.out.println(line);
    }
    catch(Exception e) {
        System.out.println(e.toString());
    }
}

// true
// Hello!
// Process finished with exit code 0