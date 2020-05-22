@Entity
public class Child implements Serializable {

    private ChildId childId;

    private Parent parent;

    @EmbeddedId
    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }

    @ManyToOne
    @JoinColumn(name="PARENT_ID", insertable=false, updatable=false)
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    /**
      * Composite primary key class MUST override equals and hashCode
      */
    @Embeddable
    public static class ChildId implements Serializable {

        private MutableInt parentId = new MutableInt();

        private Integer chId;

        public void setParentIdAsMutableInt(MutableInt parentId) {
            this.parentId = parentId;
        }

        @GeneratedValue
        public Integer getChId() {
            return chId;
        }

        public void setChId(Integer chId) {
            this.chId = chId;
        }

        @Column(name="PARENT_ID")
        public Integer getParentId() {
            return parentId.intValue();
        }

        public void setParentId(Integer parentId) {
            this.parentId.setValue(parentId);
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof ChildId))
                return false;

            final ChildId other = (ChildId) o;
            return new EqualsBuilder()
                       .append(getChId(), other.getChId())
                       .append(getParentId(), other.getParentId()).isEquals();
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + getParentId().hashCode();
            hash = 11 * hash + getChId().hashCode();
            return hash;
        }

    }

}