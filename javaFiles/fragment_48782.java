// A very naive partial K-D Tree implementation with K = 2 for Points.
public class TwoDTree
{
    private Node _root;

    public void Insert(Point coordinate)
    {
        _root = Node.Insert(coordinate, _root, 0);
    }

    public Point FindNearest(Point to, out double bestDistance)
    {
        bestDistance = double.MaxValue;
        var best = Node.FindNearest(to, _root, 0, null, ref bestDistance);
        return best != null ? best.Coordinate : null;
    }

    public IEnumerable<Point> GetPoints()
    {
        if (_root != null)
            return _root.GetPoints();
        return Enumerable.Empty<Point>();
    }

    private class Node
    {
        private Node _left;
        private Node _right;

        public Node(Point coord)
        {
            Coordinate = coord;
        }

        public readonly Point Coordinate;

        public IEnumerable<Point> GetPoints()
        {
            if (_left != null)
            {
                foreach (var pt in _left.GetPoints())
                    yield return pt;
            }
            yield return Coordinate;

            if (_right != null)
            {
                foreach (var pt in _right.GetPoints())
                    yield return pt;
            }
        }

        // recursive insert (non-balanced).
        public static Node Insert(Point coord, Node root, int level)
        {
            if (root == null)
                return new Node(coord);

            var compareResult = ((level % 2) == 0)
                ? coord.X.CompareTo(root.Coordinate.X)
                : coord.Y.CompareTo(root.Coordinate.Y);

            if (compareResult > 0)
                root._right = Insert(coord, root._right, level + 1);
            else
                root._left = Insert(coord, root._left, level + 1);
            return root;
        }

        public static Node FindNearest(Point coord, Node root, int level, Node best, ref double bestDistance)
        {
            if (root == null)
                return best;

            var axis_dif = ((level % 2) == 0)
                ? coord.X - root.Coordinate.X
                : coord.Y - root.Coordinate.Y;

            // recurse near & maybe far as well
            var near = axis_dif <= 0.0d ? root._left : root._right;
            best = Node.FindNearest(coord, near, level + 1, best, ref bestDistance);
            if (axis_dif * axis_dif < bestDistance)
            {
                var far = axis_dif <= 0.0d ? root._right : root._left;
                best = Node.FindNearest(coord, far, level + 1, best, ref bestDistance);
            }

            // do we beat the old best.
            var dist = root.Coordinate.DistanceTo(coord);
            if (dist < bestDistance)
            {
                bestDistance = dist;
                return root;
            }
            return best;
        }
    }
}

// Mitchell Best Candidate algorithm, using the K-D Tree.
public class MitchellBestCandidate
{
    private const int MaxX = 420;
    private const int MaxY = 320;
    private readonly int _maxCandidates;
    private readonly int _maxPoints;
    private readonly Random _rnd;
    private readonly TwoDTree _tree = new TwoDTree();

    public MitchellBestCandidate(int maxPoints, int maxCandidatesPerRound)
    {
        _maxPoints = maxPoints;
        _maxCandidates = maxCandidatesPerRound;
        _rnd = new Random();
    }

    public IEnumerable<Point> CurrentPoints
    {
        get { return _tree.GetPoints(); }
    }

    public void Generate()
    {
        _tree.Insert(GetRandomPoint(_rnd, MaxX, MaxY));
        for (var i = 1; i < _maxPoints; i++)
        {
            var bestDistance = double.MinValue;
            var bestCandidate = default(Point);
            for (var ci = 0; ci < _maxCandidates; ci++)
            {
                var distance = default(double);
                var candidate = GetRandomPoint(_rnd, MaxX, MaxY);
                var nearest = _tree.FindNearest(candidate, out distance);
                if (distance > bestDistance)
                {
                    bestDistance = distance;
                    bestCandidate = candidate;
                }
            }
            _tree.Insert(bestCandidate);
        }
    }

    private static Point GetRandomPoint(Random rnd, int maxX, int maxY)
    {
        return new Point(rnd.Next(maxX), rnd.Next(maxY));
    }
}