try {
        Process proc = Runtime.getRuntime().exec("python C:\Users\Me\HelloWorld.py");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String result = null;
        while ((result = reader.readLine()) != null) {
            PrintWriter out = resp.getWriter();
            out.println("<div>" + result + "</div>");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }