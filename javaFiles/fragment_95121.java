@JsonSerialize(using = EventsSearchResponseSerializer.class)
@XmlRootElement(name = "EventsSearchResponse")
public static class EventsSearchResponse {
    @XmlElement(name = "MapEntry")
    public List<MapEntryType> mapEntries; 
}