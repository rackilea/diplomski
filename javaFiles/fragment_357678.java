String text = "test On blah more blah wrote:\n" 
                + "blah blah blah\nblah blah\nblah\n";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Pattern PATTERN = Pattern.compile("^(.*?)\\s*On\\s(.+)wrote:$", 
                Pattern.MULTILINE);
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            pw.println(m.group(1));
        }
        pw.close();
        System.out.println(sw);