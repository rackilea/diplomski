// the maximum number of shades between blue and red
int step = 4;    // the value cannot be 1 (otherwise use a Color constant!)

double stepScale = 256 / (step - 1);
double halfStepScale = stepScale / 2;
ratio = Math.ceil((int) ((ratio * 256 + halfStepScale) / stepScale) * stepScale) / 256d;