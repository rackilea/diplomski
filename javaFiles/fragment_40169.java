@RequestMapping(value = "validaProgetti", method=RequestMethod.POST)
public @ResponseBody String validaProgetti(@RequestBody List<Integer> checkedRowList) {

    System.out.println("Numero progetti da validare: " + checkedRowList);

    return "blablabla";
}