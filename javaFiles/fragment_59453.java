@Controller
public StuffController
{
    @RequestMapping("bla")
    public ModelAndView doBla()
    {
        ModelAndView view = new ModelAndView();
        // Get memberSearchResults somehow
        MemberSearchResult results = memberSearchResults.getResults();
        view.addAtrribute("memberList", results);
        view.setViewName("blaview");
        return view;
    }
}