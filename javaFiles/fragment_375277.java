import java.awt.Point;

public class MouseMovementEvent {
    private Point startPoint;
    private Point endPoint;
    private Long  startNanoTime;
    private Long  endNanoTime;

    public MouseMovementEvent(Point startPoint, Point endPoint, Long startNanoTime, Long endNanoTime) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startNanoTime = startNanoTime;
        this.endNanoTime = endNanoTime;
    }

    public Point getStartPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Long getStartNanoTime() {
        return startNanoTime;
    }
    public Long getEndNanoTime() {
        return endNanoTime;
    }       
    public Long getMotionDurationInNanos() {
        return endNanoTime - startNanoTime;
    }
}