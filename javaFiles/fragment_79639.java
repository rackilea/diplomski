/*
 * public enum VehicleType { //ECONOMY, COMPACT, SUV; }
 */
// do I need to include the enum in this class as well?

public static final int MAX_ECONOMY = 10;
public static final int MAX_SEDAN = 5;
public static final int MAX_SUV = 5;

static Map<VehicleType, Integer> availEconomy = new EnumMap<VehicleType, Integer>(VehicleType.class);
static {
    availEconomy.put(VehicleType.ECONOMY, MAX_ECONOMY);
}