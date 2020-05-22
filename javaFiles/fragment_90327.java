//Pattern pattern = Pattern.compile("");
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(tempPI);
        String emailTemp = "";
        if(matcher.find()){
            emailTemp = matcher.group();
            System.out.println(emailTemp);
            //PI.replace(emailTemp, "");
            System.out.println(emailTemp.replace(emailTemp, ""));