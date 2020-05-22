public class Absence implements Serializable {
    ...
    @JoinColumns[
        @JoinColumn(name = "TimeTable_Period", referencedColumnName = "Period", ...),
        @JoinColumn(name = "????", referencedColumnName = "Day", ...),
        @JoinColumn(name = "Class_idClass", referencedColumnName = "Class_idClass", ...)
    ]
    @ManyToOne(optional = false)
    private TimeTable timeTable;
    ...
}