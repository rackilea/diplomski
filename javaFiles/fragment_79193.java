@Controller
    @Scope("session")
    @SessionAttributes(
        {
        "sharedList"
    })    
    public class MyPageController implements Serializable
    {

        @ModelAttribute("sharedList")
        public List<Pojo1> createSharedList()
        {
            return new ArrayList<Pojo1>();
        }


        @RequestMapping(value = "/myPage", method = RequestMethod.GET)
        @ResponseBody
        public ModelAndView myPage(HttpSession session)
        {
            createSharedList();
            return new ModelAndView("myPage");
        }
    -
    -
    -