@RequestMapping("/search")  
public String search(@ModelAttribute Travel search, Pageable pageable, Model model) {  
Specification<Travel> spec = new TravelSpecification(search);
    Page<Travel> travels  = travelRep.findAll(spec, pageable);
    model.addObject("page", new PageWrapper(travels, "/search"));
    return "travels/list";
}