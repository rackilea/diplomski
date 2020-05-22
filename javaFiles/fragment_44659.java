public interface Sectionable<E extends Enum<E>> {
    E getSection();
    void setSection(E value);
}

@Entity
public class Project1Entity
implements Sectionable<Section1> {
    @Embedded
    private ProjectData data = new ProjectData();

    @Column(name = "section", nullable = false)
    @Enumerated(EnumType.STRING)
    private Section1 section;

    public ProjectData getData() {
        return data;
    }

    public void setData(ProjectData newData) {
        Objects.requireNonNull(newData, "Data cannot be null");
        this.data = newData;
    }

    @Override
    public Section1 getSection() {
        return section;
    }

    @Override
    public void setSection(Section1 section) {
        Objects.requireNonNull(section, "Section cannot be null");
        this.section = section;
    }
}