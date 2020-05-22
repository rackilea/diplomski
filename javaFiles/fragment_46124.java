double remaining_time;
final double step_size;
public void update(double diff) {
    remaining_time += diff;
    while (remaining_time >= step_size) {
        step(step_size); // perform your actual physics logic
        remaining_time -= step_size;
    }
}