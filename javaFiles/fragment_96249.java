URL connectURL = new URL("http://vmalloc.in/so.php");
    BufferedReader in = new BufferedReader(new InputStreamReader(
            connectURL.openStream()));

    String inputLine;
    StringBuilder sb = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
        System.out.println(inputLine);
        sb.append(inputLine);
    }
    // array below should store input from .php file after i thrown "split"
    // text
    String[] strArray2 = sb.toString().split("split");
    System.out.println(strArray2);
    in.close();