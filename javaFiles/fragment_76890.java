@JsonTypeInfo(use = Id.NAME, include = As.WRAPPER_OBJECT)
@JsonSubTypes({ @Type(value = ApplicationIcon.class, name = "application"),
                @Type(value = FolderIcon.class, name = "folder") })
public interface Icon {

}