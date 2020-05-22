final float scalingFactor;
if (level < 50) {
    // Convert (1..50) range into (0..1) range.
    final float interp = (level - 1) / 49.0;

    // Convert (0..1) range into (1/3..3/3) range.
    scalingFactor = ((interp * 2.0) + 1.0) / 3.0;
}
else {
    // Convert (50..100) range into (0..1) range.
    final float interp = (level - 50) / 50.0;

    // Convert (0..1) range into (1..3) range.
    scalingFactor = (interp * 2.0) + 1.0;
}

return damage * scalingFactor;