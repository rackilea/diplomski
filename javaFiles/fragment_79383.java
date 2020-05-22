// when your user visits /page-1.htm, it returns public/page1.jsp as the view
@RequestMapping("/page-1")
public String showPage1() {
    return "public/page1";
}

// when your user visits /secure/page-3.htm, it returns protected/page3.jsp as the view
@RequestMapping("/secure/page-3")
public String showPage3() {
    return "protected/page3";
}