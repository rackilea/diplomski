String s = "The quick brown fox test =\"jumped over\" the \"lazy\" dog";
String lastStr = new String();
String t = new String();

Pattern pat = Pattern.compile("test\\s*=\\s*\".*\"");
Matcher mat = pat.matcher(s);

        while (mat.find()) {

            // arL.add(mat.group());
            lastStr = mat.group();

        }

Pattern pat1 = Pattern.compile("\".*\"");
        Matcher mat1 = pat1.matcher(lastStr);

        while (mat1.find()) {

            t = mat.replaceAll("test=" + "\"Hello\"");

        }

        System.out.println(t);