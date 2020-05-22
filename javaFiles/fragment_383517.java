@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseFormController {

    ProductManager productManager;

    @Autowired
    public PriceIncreaseFormController(ProductManager productManager) {
        this.productManager = productManager;
    }

    // note: this method does not have to be called onSubmit
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("priceIncrease") PriceIncrease priceIncrease, BindingResult result, SessionStatus status {

        new PriceIncreaseValidator().validate(priceIncrease, result);
        if (result.hasErrors()) {
            return "priceincrease";
        }
        else {
            int increase = priceIncrease.getPercentage();
            productManager.increasePrice(increase);
            status.setComplete();
            return "redirect:hello.htm";
        }
    }

    // note: this method does not have to be called setupForm
    @RequestMapping(method = RequestMethod.GET)    
    public String setupForm(Model model) {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        model.addAttribute("priceIncrease", priceIncrease);
        return "priceincrease";
    }

}