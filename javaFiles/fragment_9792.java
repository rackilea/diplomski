lastTrailAdd = now;
trail.add(pos.Copy());
if (trail.size() > TRAIL_MAX_COUNT) {
    trail.remove();
}
FillTrail();