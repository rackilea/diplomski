String a = "\"abc@gmail.com\",\"10.9.2.34\"";
        String arr[] = a.split(",");
        System.out.println(Arrays.toString(arr));

        for (String aa : arr) {
            if (aa.contains("@")) {
                System.out.println(aa.substring(aa.indexOf("@") + 1, aa.length() - 1));
            } else {
                System.out.println(aa.substring(1, aa.length() - 1));
            }
        }