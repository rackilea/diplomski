String str = FileUtils.readFileToString(file);
Pattern p = Pattern.compile("\\r\\n[\\r\\n]+");
String[] result = p.split(str);

 for(int i=2;i<result.length;i++)
    {
        System.out.println(result[i]);
    }