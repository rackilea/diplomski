cam = new PerspectiveCamera(80, w, h);
    cam.position.set(0, 0, -1);
    cam.lookAt(0, 0, 0);
    cam.near = 0.1f;
    cam.far = 500;
    cam.update();