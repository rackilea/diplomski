@XmlRootElement(name = "SearchResults")
@XmlAccessorType(XmlAccessType.FIELD)
public static class SearchResults {
    @XmlElement(name = "TotalHotelsFound")
    private int totalHotelsFound;
    @XmlElement(name = "CheckInDate")
    private Date checkInDate;
    @XmlElement(name = "CheckOutDate")
    private Date checkOutDate;
    @XmlElement(name = "Currency")
    private String currency;
    @XmlElement(name = "SearchId")
    private String searchId;
    @XmlElementWrapper(name = "Hotels")
    @XmlElement(name = "Hotel")
    private List<Hotel> hotels;

}