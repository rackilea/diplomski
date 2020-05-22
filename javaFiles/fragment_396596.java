@Autowired
BaseEventDAO baseEventDAO;


@Autowired
TeamDAO teamDAO;

/* to save an baseEvent */
@PostMapping("/baseEvent")
public BaseEvent createBaseEvent(@Valid @RequestBody BaseEvent baseEvent) {
    Team team = this.teamDAO.findOne(baseEvent.getFirstTeamId());
    BaseEvent event = new BaseEvent();
    event.setStartTime(baseEvent.getStartTime());
    event.setFirstTeam(team);
    event.setFirstTeamId(baseEvent.getFirstTeamId());
    return this.baseEventDAO.save(event);
}