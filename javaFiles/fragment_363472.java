@OneToMany
@JoinColumn(name="task_id")
@OrderBy("created")
List<TaskNote> notes;
public List<TaskNote> getNotes() {return notes;}
public void setNotes(List<TaskNote> notes) {this.notes = notes;}