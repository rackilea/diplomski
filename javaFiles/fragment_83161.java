@JoinTable(name = "TOPIC_WRITER", joinColumns = {
        @JoinColumn(name = "topicname", referencedColumnName = "topicname")}, inverseJoinColumns = {
        @JoinColumn(name = "writerid", referencedColumnName = "writerid")})
    @ManyToMany
    private List<Writer> writerList;

@ManyToMany(mappedBy = "writerList")
    private List<Topic> topicList;