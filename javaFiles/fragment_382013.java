@Entity 
@IdClass(WeekEmbed.class)
@Table(name = "week_effort")
public class Week_Effort implements Serializable  {

private static final long serialVersionUID = -2825819221813101109L;

@Id
@Column(name="week_id") 
private int week_id;

//Delete this part
//@Id
//@Column(name="timesheet_id")
//private int timesheet_id;

@Column(name="day1")
private int day1;

@Id
@ManyToOne(fetch = FetchType.LAZY )
@JoinColumn(name="timesheet_id" , referencedColumnName = "timesheet_id",insertable=false, updatable=false , foreignKey = @ForeignKey(name = "fkweekts"))
private Timesheet timesheet_id ;
.
.
.
//get and set
}