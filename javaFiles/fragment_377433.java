private Employer employer;
.
.
.

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="employer_id")
public Employer getEmployer() {
   return this.employer;
}