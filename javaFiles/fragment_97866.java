String str = "a;b&c &amp;";

str  = str.replaceAll("(&\\w+);", "$1XXX")
          .replaceAll("&(?!\\w+?XXX)|[^\\w&]", "")
          .replaceAll("(&\\w+)XXX", "$1;");

System.out.println(str);