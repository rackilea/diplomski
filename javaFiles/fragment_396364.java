public static IEnumerable<PointF> SortPoints(IEnumerable<PointF> input)
    {
        var sorted = new PointF[4];
        var listedInput = input.ToList();

        // top-left     --> min(x+y)
        sorted[0] = listedInput.GroupBy(x => x.X + x.Y).OrderBy(x => x.Key).First().First();
        // bottom-right --> max(x+y)
        sorted[2] = listedInput.GroupBy(x => x.X + x.Y).OrderByDescending(x => x.Key).First().First();
        // top-right    --> min(x-y)
        sorted[1] = listedInput.GroupBy(x => x.X - x.Y).OrderBy(x => x.Key).First().First();
        // bottom-left  --> max(x-y)
        sorted[3] = listedInput.GroupBy(x => x.X - x.Y).OrderByDescending(x => x.Key).First().First();

        return sorted;
    }