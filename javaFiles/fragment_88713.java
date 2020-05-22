try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("koce_podatki.txt", true)));
    out.println(temp);
    out.close();
} catch (IOException e) {
    //oh noes!
}