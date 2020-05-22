try {
                URL url = new URL("https:\\192.168.1.252\\monitor_wav\\OUT7048-20180503-083949-1525316989.211806.wav");
    URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }