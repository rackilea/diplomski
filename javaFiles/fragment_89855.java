/**
 * Adds an YAxis to the chart. You can use {@link #setyAxis(Axis)} if you want
 * to define a single axis only.
 * 
 * @param yAxis
 *          the YAxis to add.
 * @return the {@link Options} object for chaining.
 */
public Options addyAxis(final Axis yAxis) {
    if (this.getyAxis() == null) {
        this.setyAxis(new ArrayList<Axis>());
    }
    this.getyAxis().add(yAxis);
    return this;
}