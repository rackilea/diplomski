@Entity
public class Event {
   ...
   @OneToMany(mappedBy = "event")
   Set<EventPhase> eventPhases = new HashSet<>();
}