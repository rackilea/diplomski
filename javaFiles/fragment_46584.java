@Controller
public class HomeController {
    private static final long serialVersionUID = 1L;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("authentification");
        return model;
    }
    @RequestMapping(method=RequestMethod.POST)
    public void service(@RequestAttribute("smya") Str1, @RequestAttribute("mdps") Str2){
        System.out.println(Str1);
        System.out.println(Str2);
        try {
            URL url = new URL("<code>http://pc-demo-bi:8090/jasperserver-pro/rest/login?j_username="+Str1+"&j_password="+Str2</code>);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                + conn.getResponseCode());
            }
            System.out.println("connected");
                return("rapports");
                conn.disconnect();
        } 
        catch (MalformedURLException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}