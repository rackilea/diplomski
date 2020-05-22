private Camera.Size getOptimalPreviewSize(List<Size> sizes, int targetWidth, int targetHeight) {
    final double aspectTolerance = 0.05;
    final double targetRatio = (double) targetWidth/targetHeight;

    if (sizes == null) {
      return null;
    }

    Camera.Size optimalSize = null;
    double minDiff = Double.MAX_VALUE;

    for (Camera.Size size : sizes) {
      final double ratio = (double) size.width / size.height;
      if (Math.abs(ratio - targetRatio) > aspectTolerance) continue;
      if (Math.abs(size.height - targetHeight) < minDiff) {
        optimalSize = size;
        minDiff = Math.abs(size.height - targetHeight);
      }
    }

    if (optimalSize == null) {
      minDiff = Double.MAX_VALUE;
      for (Camera.Size size : sizes) {
        if (Math.abs(size.height - targetHeight) < minDiff) {
          optimalSize = size;
          minDiff = Math.abs(size.height - targetHeight);
        }
      }
    }

    return optimalSize;
  }