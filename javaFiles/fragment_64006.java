BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
while (true) {
    String misc = in.readLine();
    System.out.println(misc);
    if (misc==null || misc.length()==0)
        break;
}
in.close();