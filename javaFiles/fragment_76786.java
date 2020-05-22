@RequestMapping(value = "/eblinb2b/OutInCompare", method = RequestMethod.GET, 
                    headers="Accept=*/*",produces = "application/json")
public @ResponseBody List<EblInvB2B> filterByDate(Model model, @RequestParam("count") int count) {

// Fetch data from the DAO
List<EblInvB2B> eblinb2b_filter_counting = accountSservice.findByDateRangeEB2B(count);

// We add to the model (JSP page the list of EBLINVB2B)
model.addAttribute("eblinb2b_filter_counting", eblinb2b_filter_counting);

return eblinb2b_filter_counting;

}