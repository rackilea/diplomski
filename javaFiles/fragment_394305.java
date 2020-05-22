// update nifty
        nifty.update();

        // save your OpenGL state
        // (assuming you are in glMatrixMode(GL_MODELVIEW) all the time)
        glPushMatrix();
        glPushAttrib(GL_ALL_ATTRIB_BITS);

        // render Nifty (this will change OpenGL state)
        nifty.render(false);

        // restore your OpenGL state
        glPopAttrib();
        glPopMatrix();