static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
OkHttpClient client = new OkHttpClient();

String post(String url, String json) throws IOException {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();
    try (Response response = client.newCall(request).execute()) {
        return response.body().string();
    }
}

try {
        String json = "";
        String response = post("http://my-api.com/images", json);

        JSONObject JsonResponse = new JSONObject(response);
        JSONArray devices = JsonResponse.getJSONArray("response");

        int rows = (devices.length() / 4) + 3;
        resultsPanel.setLayout(new GridLayout(rows, 0, 20, 20));

        for(int d = 0; d < devices.length(); d++){

            // store device details
            JSONObject selectedDevice = devices.getJSONObject(d);

            // create button
            JButton device = new JButton();

            // extracting icon url from api response
            URL imageURL = new URL(devices.getJSONObject(d).get("brandImage").toString());

            // style button
            Border lineBorder = new LineBorder(new java.awt.Color(238, 238, 238));
            Border padding = new EmptyBorder(0, 10, 0, 0);

            device.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stock_image.png")));
            device.setIconTextGap(20);
            device.setText(devices.getJSONObject(d).get("name").toString());
            device.setPreferredSize(new Dimension(100, 100));
            device.setBackground(new java.awt.Color(255, 255, 255));
            device.setFont(new java.awt.Font("Arial", 0, 12));
            device.setVerticalTextPosition(SwingConstants.BOTTOM);
            device.setHorizontalTextPosition(SwingConstants.CENTER);
            device.setBorder(new CompoundBorder(lineBorder, padding));
            device.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            device.setFocusable(false);

            // add button to panel
            resultsPanel.add(device);

            // asynchronously load images from api response
            new ImageWorker(imageURL, device).execute();
        }

    } catch (IOException ex) {
        Logger.getLogger(ISoD.class.getName()).log(Level.SEVERE, null, ex);
    }