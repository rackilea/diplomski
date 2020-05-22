MultiMap timeWindows = new MultiValueMap();
        timeWindows.put("open", "123");
        timeWindows.put("close", "124");
        timeWindows.put("open", "523");
        timeWindows.put("close", "524");
        timeWindows.put("open", "823");
        timeWindows.put("close", "824");

        System.out.println("timeWindows : "+timeWindows);