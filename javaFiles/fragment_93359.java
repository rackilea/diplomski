@RequestMapping(value="/availability", method=RequestMethod.GET)
public @ResponseBody AvailabilityStatus getAvailability(@RequestParam String name) {
    for (Account a : accounts.values()) {
        if (a.getName().equals(name)) {
            return AvailabilityStatus.notAvailable(name);
        }
    }
    return AvailabilityStatus.available();
}