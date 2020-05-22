String data = "https://example.com/test?abc=12345678901234567890123456&mnr=12345678901234567890123456";

String result = data.replaceAll("(?<=abc=)[0-9]{14}(?=[0-9]{6})",
            "**************");

System.out.println(result);