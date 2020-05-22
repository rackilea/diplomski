glTexCoord2f(1, 1);
            glVertex2i(640, 0);
            glTexCoord2f(0, 1);
            glVertex2i(0, 0);
            glTexCoord2f(0, 0);
            glVertex2i(0, 480);

            glTexCoord2f(0, 0);
            glVertex2i(0, 480);
            glTexCoord2f(1, 0);
            glVertex2i(640, 480);  // <--- this line was 640,640?
            glTexCoord2f(1, 1);
            glVertex2i(640, 0);