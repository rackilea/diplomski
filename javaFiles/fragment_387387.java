@RequestMapping("/scriptfile/**")
@Controller
public class ScriptFileController {

    //we need a special property-editor that knows how to bind the data
    //from the request to a byte[]
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/scriptfile", method = RequestMethod.POST)    
    public String create(@Valid ScriptFile scriptFile, BindingResult result, ModelMap modelMap) {    
        if (scriptFile == null) throw new IllegalArgumentException("A scriptFile is required");        
        if (result.hasErrors()) {        
            modelMap.addAttribute("scriptFile", scriptFile);            
            modelMap.addAttribute("showcases", ShowCase.findAllShowCases());            
            return "scriptfile/create";            
        }        
        scriptFile.persist();        
        return "redirect:/scriptfile/" + scriptFile.getId();        
    }    
}