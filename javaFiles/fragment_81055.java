System.out.println("Quieres continuar? S/s o N/n");
    boolean gotit = false;
    while (!gotit) {
        String response = scan.nextLine().toLowerCase().trim();
        bool = response.equals("s");
        gotit = (response.equals("n") || response.equals("s"));
    }