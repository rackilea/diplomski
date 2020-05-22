@Id
@Getter
@Access(AccessType.PROPERTY)
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

public void setId(Long id) {
    this.id = id;
    this.getLocale(Language.CS).setEmbedId(id);
    this.getLocale(Language.EN).setEmbedId(id);
}