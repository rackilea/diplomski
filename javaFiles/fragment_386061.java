QuickHull (S, l, r)

     if S={ }    then return ()
else if S={l, r} then return (l, r)  // a single convex hull edge
else
    z = index of a point that is furthest (max distance) from xy.
    Let A be the set containing points strictly right of (x, z)
    Let B be the set containing points strictly right of (z, y)
    return {QuickHull (A, x, z) U (z) U QuickHull (B, z, y)}