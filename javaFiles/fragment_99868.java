// draw the filled polygons
   glPolygonMode( GL.GL_FRONT_AND_BACK, GL.GL_FILL );
   glEnable( GL.GL_POLYGON_OFFSET_FILL );
   glPolygonOffset( 1, 1 );
   glColor3f( 0.0f, 0.0f, 0.0f );
   renderData();
   gl.glDisable( GL.GL_POLYGON_OFFSET_FILL );

   // draw the wireframe
   glPolygonMode( GL.GL_FRONT_AND_BACK, GL.GL_LINE );
   glColor4fv( colour );
   renderData();