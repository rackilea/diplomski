public static void main(String[] args) throws IOException {
    String command[] = {"java.exe", "-cp", "C:\\Users\\Mahika\\Documents\\NetBeansProjects\\JavaTest\\compilerTest", "InputInteger"};
    ProcessBuilder pb = new ProcessBuilder(command);
    Process p = pb.start();
    System.out.println("Process started");
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    System.out.println(br.readLine());
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    PrintStream ps = new PrintStream(p.getOutputStream(), true);
    ps.println(i);
    System.out.println(br.readLine());
}