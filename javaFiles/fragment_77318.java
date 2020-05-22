public class Action {
    // Action has a composite key (ID and Version ID)

    @Id
    @Column(name = "id")
    public int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "version_id")
    public Version version;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "process_id", referencedColumnName = "id"),
        @JoinColumn(name = "process_version_id", referencedColumnName = "version_id")
    })
    public Process process;
}