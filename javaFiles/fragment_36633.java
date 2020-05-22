String md5Key= "e510a13edeea112b57683d724d5d70a6";
    String detailsData = "{\n" +
"        \"acc_no\": \"1234691007924321\",\n" +
"        \"exp\": \"07/19\",\n" +
"        \"name\": \"MICHAEL XXXXXX\",\n" +
"        \"type\": \"VIS\"\n" +
"    }";

    System.out.println(encrypt(md5Key, detailsData));