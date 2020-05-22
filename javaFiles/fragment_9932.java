String mydata = "<script language='javascript'><!--document.write('<a href='javascript:popupWindow"
                + "(\'https://www.kitchenniche.ca/prepara-adjustable-oil-pourer-pi-5597.html?invis=0\')'><img "
                + "src='images/imagecache/prepara-adjustable-oil-pourer-1.jpg' border='0' alt='Prepara Adjustable Oil Pourer' "
                + "title=' Prepara Adjustable Oil Pourer ' width='170' height='175' hspace='5' vspace='5'><br></a>');</script>";
        Pattern pattern = Pattern.compile("src='(.*?)'");
        Matcher matcher = pattern.matcher(mydata);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }