TangoSupport.TangoMatrixTransformData transform =
  TangoSupport.getMatrixTransformAtTime(pointCloud.timestamp,
          TangoPoseData.COORDINATE_FRAME_START_OF_SERVICE,
          TangoPoseData.COORDINATE_FRAME_CAMERA_DEPTH,
          TangoSupport.TANGO_SUPPORT_ENGINE_OPENGL,
          TangoSupport.TANGO_SUPPORT_ENGINE_TANGO);

// Convert it into the matrix format you use in render.
// This is a pure data structure conversion, transform is
// in opengl world frame already.
Matrix4x4 model_matrix = ConvertMatrix(transform);

foreach (Point p in pointCloud) {
  p = model_matrix * p;
}

// Now p is in opengl world frame.