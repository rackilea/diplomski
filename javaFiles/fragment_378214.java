@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlayerSpawnedEvent.class, name = "PlayerSpawnedEvent"),
        @JsonSubTypes.Type(value = PlayerStateChangedEvent.class, name = "PlayerStateChangedEvent")
})

public abstract class AbstractEvent
{
    @JsonView(Views.Detailed.class)
    public String type;

    @JsonView(Views.Detailed.class)
    public String id;

    @JsonView(Views.Minimal.class)
    public long time;
}

public class PlayerSpawnedEvent
{
    public PlayerSpawnedEvent() { type = "PlayerSpawnedEvent"; }
}

public class PlayerStateChangedEvent
{
    public PlayerStateChangedEvent() { type = "PlayerStateChangedEvent"; }
}