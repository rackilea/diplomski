StringBuffer results = new StringBuffer();
String separator = ","
float[][] values = new float[50][50];

// init values

for (int i = 0; i < values.length; ++i)
{
  result.append('[');
  for (int j = 0; j < values[i].length; ++j)
    if (j > 0)
      result.append(values[i][j]);
    else
      result.append(values[i][j]).append(separator);
  result.append(']');
}