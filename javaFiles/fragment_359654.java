String html = "<img src=\"folder1/mylogo.jpg\" ... />";
        Pattern pattern = Pattern.compile("src=\"([\\:\\w\\s\\/]+)\\.\\w{3}\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.println("group 1: " + matcher.group(1));
            //This line will give you the wanted output.
            System.out.println("src=\"cid:"+matcher.group(1)+"\"");
            System.out.println("Final Result: "+html.replaceAll("src=\"([\\:\\w\\s\\/]+)\\.\\w{3}\"", "src=\"cid:$1\""));
        }