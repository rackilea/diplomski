@OneToOne()
@JoinColumn(name="vehicle_id", referencedColumnName="vehicleId")
@ForeignKey(name="Fk_userdetails_vehicle")
public Vehicle getVehicle() {
   return vehicle;
}