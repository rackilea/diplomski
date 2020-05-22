@XmlRootElement(name="LabbuddyArray")
public class Identity {
    List<Slots> slots;

    @XmlElement(name="slot")
    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

}