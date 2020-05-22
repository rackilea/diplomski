float[] a = new float[]{x1, y1};
float[] n = new float[]{x2-x1, y2-y1};
normalize(n);
float[] p = new float[]{x, y};

float[] aMinusP = subtract(a, p);
float aMinusPDotn = dot(aMinusP, n);

// vec2a.vec2b
float dot(float[] vec2a, float[] vec2b)
{
   return vec2a[0]*vec2b[0] + vec2a[1]*vec2b[1];
}

// ||vec2||
float len(float[] vec2)
{
   return (float)Math.Sqrt(dot(vec2, vec2));
}

// vec2/||vec2||
void normalize(float[] vec2)
{
  float length = len(vec2);
  vec2[0] /= length;
  vec2[1] /= length;
}

// vec2a - vec2b
float[] subtract(float[] vec2a, float[] vec2b)
{
  return new float[]{vec2a[0]-vec2b[0],vec2a[1]-vec2b[1]};
}