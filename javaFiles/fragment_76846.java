@Entity
    @Table(name="CASE_REMINDER_OPR")
    public class CaseReminderOpr implements Serializable {
        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private CaseReminderOprPK pk;

        @ManyToOne
        @JoinColumn(name = "CASE_ID", insertable=false, updatable=false)
        private CaseReminders caseRem;
    }