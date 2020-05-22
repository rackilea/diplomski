@Data
public class AssureursDTO {

    private Long n_assureur;

    private String name;

    public AssureursDTO(Long n_assureur, String name) {
        this.n_assureur = n_assureur;
        this.name = name;
    }
}