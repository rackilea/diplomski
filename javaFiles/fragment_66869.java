Path path = new Path();

// Start at the top left corner
path.moveTo(screenCenterX - halfMarkerTopWidth, topMargin);

// Draw a line to the top right corner
path.lineTo(screenCenterX + halfMarkerTopWidth, topMargin);

// Draw a line to the bottom right corner
path.lineTo(screenCenterX + halfMarkerBottomWidth, topMargin + markerHeight);

// Draw a line to the bottom left corner
path.lineTo(screenCenterX - halfMarkerBottomWidth, topMargin + markerHeight);

// Close the Path (will automatically draw a line back to the top left corner)
path.close();