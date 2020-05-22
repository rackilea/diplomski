try {
        URL url = new URL("http://www.google.com");
        HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
        urlConnect.setConnectTimeout(1000);
        urlConnect.getContent();
        System.out.println("Connection established.");
    } catch (NullPointerException np) {
        np.printStackTrace();
    } catch (IOException io) {
        io.printStackTrace();
    }