public class Borrower {

    private String bncr;
    public String getBncr() { return bncr; }
    public void setBncr(String bncr) { this.bncr = bncr; }

    private Integer cgc;
    public Integer getCgc() { return cgc; }
    public void setCgc(Integer cgc) { this.cgc = cgc; }

    private String ucr;
    public String getUcr() { return ucr; }
    public void setUcr(String ucr) { this.ucr = ucr; }

    private Double pd;
    public Double getPd() { return pd; }
    public void setPd(Double pd) { this.pd = pd; }

    private Integer agic;
    public Integer getAgic() { return agic; }
    public void setAgic(Integer agic) { this.agic = agic; }

    private String bookingLocation;
    public String getBookingLocation() { return bookingLocation; }
    public void setBookingLocation(String bookingLocation) { this.bookingLocation = bookingLocation; }

    private Integer salesTurnover;
    public Integer getSalesTurnover() { return salesTurnover; }
    public void setSalesTurnover(Integer salesTurnover) { this.salesTurnover = salesTurnover; }

    private List<Facility> faciliies;
    public List<Facility> getFaciliies() { return faciliies; }
    public void setFaciliies(List<Facility> faciliies) { this.faciliies = faciliies; }

}