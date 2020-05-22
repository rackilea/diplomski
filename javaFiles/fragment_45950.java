@RequestMapping(value = "/regions")
@ResponseBody
public Set getRegions(@RequestParam String country) {
    Map<String, Set<String>> regions = regionsService.getRegions();
    return regions.get(country);
}