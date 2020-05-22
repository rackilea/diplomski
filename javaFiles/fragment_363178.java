@Controller
@ControllerAdvice
public class HomeSponsors extends AbstractController {

    @RequestMapping("/sponsorsPage")
    public String sponsorsPage(Model model) {
        return "sponsorsPage";
    }

    @ModelAttribute("sponsorsList")
    public List<Sponsors> sponsorsList() {
        return new GetSponsorsList().getListSponsors();
    }

}