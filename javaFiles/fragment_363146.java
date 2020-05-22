@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClaimImportCompositeDTO {
    private String _claimId;
    private String _claimNumber;
    private ClaimDTO _claimDTO;
    private List<NotepadDTO> _notepadDTO;

    public String getClaimId() {
        return _claimId;
    }

    public String getClaimNumber() {
        return _claimNumber;
    }

    public ClaimDTO getClaimDTO() {
        return _claimDTO;
    }

    @XmlElementWrapper(name = "notes")
    public List<NotepadDTO> getNotepadDTO() {
        return _notepadDTO;
    }

    public void setClaimId(String claimId) {
        this._claimId = claimId;
    }

    public void setClaimNumber(String claimNumber) {
        this._claimNumber = claimNumber;
    }

    public void setClaimDTO(ClaimDTO claimDTO) {
        this._claimDTO = claimDTO;
    }

    public void setNotepadDTO(List<NotepadDTO> notes) {
        this._notepadDTO = notes;
    }
}