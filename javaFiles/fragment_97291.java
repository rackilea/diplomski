// Polygon points
    List<Vector2> p;

    /// <summary> Calculates the perpendicular vector from nearest point on polygon to given point. If no points available minIndex is -1. </summary>
    public void GetPolygonDist(Vector2 point, out Vector2 minDist, out int minIndex) {
        if (p.Count == 0) { minDist = Vector2.Null(); minIndex = -1; return; }
        Vector2 dist;
        minDist = point - p[0];
        minIndex = 0;
        for (int i = 0; i < p.Count - 1; i++) {
            Vector2 l = p[i + 1] - p[i];                                        // Edge
            if (l.GetLength() < 1e-9) continue;                                 // Ignore edge of length almost zero
            Vector2 d = point - p[i];                                           // Polygon point to point
            Vector2 b = (l * d) / (l * l) * l;                                  // Projection to edge
            double f = Math.Sign(b * l) * (b.GetLength() / l.GetLength());      // Where on the edge is the perpendicular?
            if (f < 0.0) dist = point - p[i];                                   // Point before the edge
            else if (f > 1.0) dist = point - p[i + 1];                          // Point after the edge
            else dist = d - b;                                                  // Perpendicular
            if (dist.GetSquaredLength() < minDist.GetSquaredLength()) {
                minDist = dist;
                minIndex = i;
            }
        }
    }