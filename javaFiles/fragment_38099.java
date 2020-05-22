TessBaseAPI baseApi = new TessBaseAPI();
        baseApi.init("/mnt/sdcard/external_sd/tess/", "eng");
        baseApi.setImage(bitmap);
        String recognizedText = baseApi.getUTF8Text();
        Log.d("Texto leido", "texto: "+recognizedText);
        baseApi.end();