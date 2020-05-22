GL.createCapabilities();

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0,this.conf.width, 0, this.conf.height, -1, 1);
    glMatrixMode(GL_MODELVIEW);
    glDisable(GL_DEPTH_TEST);

    Time time = new Time();

    while(!glfwWindowShouldClose(this.display)) {

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glfwPollEvents();
        glPushMatrix();

        glBegin(GL_QUADS);

        glColor3f(1,0,1);
        glVertex2f(0, 0);
        glVertex2f(0, 64);
        glVertex2f(64, 64);
        glVertex2f(64, 0);

        glEnd();

        glPopMatrix();
        glfwSwapBuffers(this.display);

        float deltaSeconds = time.getDelta()/Time.SECOND;
        float fps = deltaSeconds;
        System.out.println(fps);

    }

    this.destroy();