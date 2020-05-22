class TimeTable{
....
@OneToMany
@JoinColumn(name = "TIME_TABLE_ID"); 
private Set<Year> years;
...
}