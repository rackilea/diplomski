@Entity
        @Table(name = "entry")
        public class Entry {
            @Column(name = "author")
            private String author;
            @Column(name = "content")
            private String body;
            @Column(name = "comment_count")
            private long commentCount;
            @OneToMany(mappedBy = "entry")
            @Cascade(CascadeType.SAVE_UPDATE)
            private List<EntryComment> comments;
        }