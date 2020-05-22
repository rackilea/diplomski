@Override
        public Response serve(String uri, Method method,
                Map<String, String> header, Map<String, String> parameters,
                Map<String, String> files) {
            File rootDir = Environment.getExternalStorageDirectory();
            File[] filesList = null;
            String filepath = "";
            if (uri.trim().isEmpty()) {
                filesList = rootDir.listFiles();
            } else {
                filepath = uri.trim();
            }
            filesList = new File(filepath).listFiles();
            String answer = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><title>sdcard0 - TECNO P5 - WiFi File Transfer Pro</title>";
            if (new File(filepath).isDirectory()) {
                for (File detailsOfFiles : filesList) {
                    answer += "<a href=\"" + detailsOfFiles.getAbsolutePath()
                            + "\" alt = \"\">"
                            + detailsOfFiles.getAbsolutePath() + "</a><br>";
                }
            } else {
            }
            answer += "</head></html>" + "uri: " + uri + " \nfiles " + files
                    + " \nparameters " + parameters + " \nheader ";
            return new NanoHTTPD.Response(answer);
        }