protected void endDrawing(DrawContext dc)
    {
        GL2 gl = dc.getGL().getGL2(); // GL initialization checks for GL2 compatibility.

        if (!dc.isPickingMode())
            dc.endStandardLighting();
        gl.glPopMatrix();
        gl.glPopAttrib();
    }