@RequestMapping(value = "admin/confirmWithdrawRequest", method = RequestMethod.GET)
public String confirmWithdrawRequestShowPage(@RequestParam(value = "error") String error, Model model) {
    Set<Event> cashOutEvents = eventJournalService.getEventsByType(EventType.CASHOUT_REQUEST);
    model.addAttribute("events", cashOutEvents);
    model.addAttribute("statuses", EventStatus.values());
    model.addAttribute("error", error);
    return "admin/confirmWithdrawRequest";
}