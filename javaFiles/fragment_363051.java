// Detect if we collided with any one (collision is the rectangle, bounds is us)
if (collision.intersects(bounds)) {
    // Determine the intersect of the collision...
    insect = collision.intersection(bounds);

    // Flags...
    boolean vertical = false;
    boolean horizontal = false;
    boolean isLeft = false;
    boolean isTop = false;

    // Left side...
    if (insect.x == collision.x) {
        horizontal = true;
        isLeft = true;
    // Right side
    } else if (insect.x + insect.width == collision.x + collision.width) {
        horizontal = true;
    }
    // Top
    if (insect.y == collision.y) {
        vertical = true;
        isTop = true;
    // Bottom
    } else if (insect.y + insect.height == collision.y + collision.height) {
        vertical = true;
    }

    // Technically, we can really only collide with a single edge...more or less
    if (horizontal && vertical) {
        // Basically, we try and give precedence to the longer edge...
        if (insect.width > insect.height) {
            horizontal = false;
        } else {
            vertical = false;
        }
    }

    // We collided with a horizontal side...
    if (horizontal) {
        dx *= -1;
        // Move the ball to the approriate edge so we don't get caught...
        if (isLeft) {
            bounds.x = collision.x - bounds.width;
        } else {
            bounds.x = collision.x + collision.width;
        }
    // We collided with a vertical side...
    } else if (vertical) {
        dy *= -1;
        // Move the ball to the approriate edge so we don't get caught...
        if (isTop) {
            bounds.y = collision.y - bounds.height;
        } else {
            bounds.y = collision.y + collision.height;
        }
    }

}