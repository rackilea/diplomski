public static void main(String[] args) {
    try(BufferedReader in = new BufferedReader(
            new InputStreamReader(new URL("http://google.com/robots.txt").openStream()))) {
        String line = null;
        while((line = in.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}