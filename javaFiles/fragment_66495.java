@GET
@Path("/health")
@Health
public HealthStatus checkHealth() {
   return isMyAppOK() ? HealthStatus.up() : HealthStatus.down();
}