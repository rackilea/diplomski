// copy from the Lance Java answer.
@RequestMapping(value="/{brand}/{category}/", method=RequestMethod.GET)
public ModelAndView search1(
    @PathVariable String brand, 
    @PathVariable String category, 
    @RequestParam String minPrice, 
    @RequestParam String maxPrice, 
    @RequestParam Integer offer)
{
    return actualSearch(brand, category, minPrice, maxPrice, offer);
}

@RequestMapping(value="/{brand}/", method=RequestMethod.GET)
public ModelAndView search1(
    @PathVariable String brand, 
    @RequestParam String minPrice, 
    @RequestParam String maxPrice, 
    @RequestParam Integer offer)
{
    return actualSearch(brand, null, minPrice, maxPrice, offer);
}

@RequestMapping(value="/brand/{brand}/category/{category}/",
    method=RequestMethod.GET)
public ModelAndView search2(
    @PathVariable String brand, 
    @PathVariable String category, 
    @RequestParam String minPrice, 
    @RequestParam String maxPrice, 
    @RequestParam Integer offer)
{
    return actualSearch(brand, category, minPrice, maxPrice, offer);
}

@RequestMapping(value="/brand/{brand}/", method=RequestMethod.GET)
public ModelAndView search2(
    @PathVariable String brand, 
    @RequestParam String minPrice, 
    @RequestParam String maxPrice, 
    @RequestParam Integer offer)
{
    return actualSearch(brand, null, minPrice, maxPrice, offer);
}



private ModelAndView actualSearch(
    final String brand,
    final String category,
    final String minPrice,
    final String maxPrice,
    final Integer offer)
{
    ... blah
}