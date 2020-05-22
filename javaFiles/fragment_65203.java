@Controller
public class EmpController {

    @Autowired
    private EmpDao dao;

    @RequestMapping("/viewemp")
    public String viewemp(Model m, Pageable pageable){
        Page<Emp> pages=dao.getPage(pageable);
        m.addAttribute("number", pages.getNumber());
        m.addAttribute("totalPages", pages.getTotalPages());
        m.addAttribute("totalElements", pages.getTotalElements());
        m.addAttribute("size", pages.getSize());
        m.addAttribute("data",pages.getContent());
        return "viewemp";
    }
}