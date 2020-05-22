// construct first line:
canvas.moveTo(position.getLeft(), position.getBottom());
canvas.lineTo(position.getRight(), position.getBottom());
// construct second line (4 user units lower):
canvas.moveTo(position.getLeft(), position.getBottom() - 4);
canvas.lineTo(position.getRight(), position.getBottom() - 4);
// draw lines
canvas.stroke();