String s = "<a name='bill_pay' href='javascript:goto(&#39;billpay&#39;);' class='fsdnav-top-menu-item'>Bill Pay <span class='fsdnav-ada-hidden'>link and menu. Press enter to navigate to this link. Press control + space to open submenu.\n" + 
        "To move through submenu items press tab and then press up or down arrow.</span> </a>\n" +
        "<a name='bill_pay' href='javascript:goto(&#39;findmyinfo&#39;);' class='fsdnav-top-menu-item'>\n" +
        "<a name='bill_pay' href='#' onClick='OOLPopUp(&#39;/myaccounts/brain/redirect.go?target=findmyroutingnumber&#39;,&#39;ool&#39;,&#39;currentPage&#39;);return false;' class='fsdnav-top-menu-item'>\n" +
        "Bill Pay <span class='fsdnav-ada-hidden'>link and menu. Press enter to navigate to this link. Press control + space to open submenu.";
Pattern regex = Pattern.compile("^(?:.*?goto\\(&#39;(\\w+)&#39;\\).*|.*?OOLPopUp\\(&#39;(.+?&#39;\\)).*)$", Pattern.MULTILINE);
 Matcher matcher = regex.matcher(s);
 while(matcher.find()){
        System.out.println(matcher.group(1) != null ?
                matcher.group(1) : matcher.group(2)
                );
}