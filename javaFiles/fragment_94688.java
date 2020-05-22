@RequestMapping(method=RequestMethod.POST, value="/json/foo.json")
public @ResponseBody Object foo(@RequestParam("ids") int[] fooIds)
{
    for (Integer id : fooIds)
    {
        fooService.delete(id);
    }
    return null;
}