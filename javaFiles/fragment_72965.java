@ManyToOne(fetch = FetchType.EAGER)
@JoinTable(name = "accommodation_booking_join_table", 
           joinColumns = {@JoinColumn(name="booking_id")},
           inverseJoinColumns = @JoinColumn(name = "accommodation_id"))
@JsonBackReference
private Accommodation accommodation;