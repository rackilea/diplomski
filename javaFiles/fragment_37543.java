@Entity
public class VehicleConfiguration extends StatefulEntity {

    @ManyToOne
    @JoinColumn(name = "year_id")
    private VehicleYear vehicleYear;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private VehicleMake vehicleMake;

    public LookupBaseEntity getInfo(final String fieldName) {
        try { 
            String methodName = WordUtils.capitalize(fieldName);
            Method method = VehicleConfiguration.class.getMethod("get" + methodName);  
            return (LookupBaseEntity) method.invoke(this); 
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(VehicleConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}