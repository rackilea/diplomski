// Convert (0..100) range into (-1..+1) range.
final float interp = (level - 50) / 50.0;

// 3^(-1) == 1/3
// 3^0    == 1
// 3^(+1) == 3
final float scalingFactor = Math.pow(3.0, interp);

return damage * scalingFactor;