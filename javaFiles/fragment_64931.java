Plank.Builder builder = new Plank.Builder();
builder.widthInches(13);
builder.heightInches(2);
// Don't set the thickness; use the default defined in the Builder's constructor.
Plank p1 = builder.build();
Plank p2 = builder.build();
// Now set the thickness to a new value
builder.thicknessInches(14);
Plank p3 = builder.build();