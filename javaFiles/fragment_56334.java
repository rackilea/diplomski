public static String getResponseFromUrlDesktop(String url) {

        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        BufferedReader in = null;
        try {
            URL website = new URL(url);
            connection = (HttpURLConnection) website.openConnection();

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();
        } catch (IOException e) {
            try {
                if (connection.getResponseCode() >= 400) {
                    in = new BufferedReader(new InputStreamReader(
                            connection.getErrorStream()));
        //                             ^^^^^^^^^^^^^^
                    String inputLine;

                    while ((inputLine = in.readLine()) != null)
                        response.append(inputLine);

                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return response.toString();

}