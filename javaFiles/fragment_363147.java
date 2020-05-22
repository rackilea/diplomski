@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClaimStatus {


    private List<ClaimStatusDTO> _claimStatusDTO;
    private boolean _statusCompleteWorkItemFlag;

    @XmlElementWrapper(name = "expired")
    public List<ClaimStatusDTO> getClaimStatusDTO() {
        return _claimStatusDTO;
    }

    public void setClaimStatusDTO(List<ClaimStatusDTO> claimStatusDto) {
        this._claimStatusDTO = claimStatusDto;
    }

    public boolean isStatusCompleteWorkItemFlag() {
        return _statusCompleteWorkItemFlag;
    }


    public void setStatusCompleteWorkItemFlag(boolean statusCompleteWorkItemFlag) {
        this._statusCompleteWorkItemFlag = statusCompleteWorkItemFlag;
    }
}