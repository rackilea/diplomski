ConstraintSet set = new ConstraintSet();
set.clone(layout);

set.constrainWidth(icon.getId(), (int)(90*scale));
set.constrainHeight(icon.getId(), (int)(90*scale));

set.connect(icon.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
set.connect(icon.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 100);

set.applyTo(layout);