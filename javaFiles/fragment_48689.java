- off_x = x1-x2;
- off_y = y1-y2;

- ls = off_x*off_x + off_y*off_y
- if ls < R*R
-- return an empty array, meaning "no intersections"

- scale = R / sqrt(ls)
- res_x = off_x * scale + x2
- res_y = off_y * scale + y2
- return [[off_x, off_y]]