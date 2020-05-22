public class Xxxx{
    @Autowired
    ServletContext context;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String upload(UploadItem uploadItem, BindingResult result, HttpServletRequest request, HttpSession session) {

       //some code here

       String name = context.getRealPath("/pdf/" + filename);
...