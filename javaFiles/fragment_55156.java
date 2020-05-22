String line;
Process p = Runtime.getRuntime().exec( "/path/to/C/executable" );

BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ((line = in.readLine()) != null) {
    System.out.println(line);
}
in.close();