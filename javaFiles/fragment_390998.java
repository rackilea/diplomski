@Controller
@RequestMapping("/secure")
public class SecureArea {

    @RequestMapping("/downloadMe.xhtml")
    public String downloadMe(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // do stuff
        return "myJsp";
    }

    @RequestMapping("/viewStuff")
    public void viewStuff(HttpServletRequest request, HttpServletResponse response) throws Exception {
        URL url = new URL("http://"+request.getServerName()+":"+request.getServerPort()+"/secure/downloadMe.xhtml");
        URLConnection con = url.openConnection();
        con.setDoOutput(true);
        // attach the session ID in the request
        con.setRequestProperty("Cookie", "JSESSIONID="+request.getSession().getId());
        con.connect();

        InputStream in = con.getInputStream();  
        // read the input stream and do stuff with it, obviously returns my 401 page
    }
}