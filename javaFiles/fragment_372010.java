if (xDistance <= radiusX && yDistance <= radiusY) {
    if (xDistance < yDistance) {
        vx *= -1;
    } else {
        vy *= -1;
    }

    System.out.println("Hit!");
}