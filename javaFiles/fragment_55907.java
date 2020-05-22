String sTripResponse = response.toString();
    String finalString = sTripResponse.substring(1, sTripResponse.length() - 1);
    String[] arr = finalString.split("#");
    for (int i = 0; i < arr.length; i++) {
        System.out.println("" + arr[i]);
    }