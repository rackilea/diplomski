public class SaisieAnomalieProjetVo extends AbstractAudited<Integer> {

private static final long serialVersionUID = 1L;

@NotNull
private int projet;

@NotNull
private Date date;

@NotNull
@NotEmpty
private String type;

@NotNull
@NotEmpty
private String reference;

private String description;

private Date dateRea;



public SaisieAnomalieProjetVo(final int project, final Date date, final Date dateRea, final String reference,
      final String description, final String type) {
    this.projet = project;
    this.date = date;
    this.dateRea = dateRea;
    this.reference = reference;
    this.description = description;
    this.type = type;
}
}