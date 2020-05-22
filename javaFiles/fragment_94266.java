Handler mainThreadHandler=new Handler();
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            URL obj = new URL(url1 + overallid);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            con.addRequestProperty("User-Agent", "Mozilla/4.76");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString().replaceAll("\\s", ""));
            System.out.println("Set pic to: " + pic);
            mainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                    Picasso.with(LoginActivity.this).load(pic).into(image);
                }
            });
            i++;
            overallid++;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}).start();