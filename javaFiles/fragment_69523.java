public static class ResultFactory

    public static Result createBlammy(
        int x,
        int y,
        int a[],
        int b[])
    {
        return new ResultBlammy(x, y, a, b);
    }

    public static Result createHooty(
        int x,
        int y,
        int a[],
        int b[])
    {
        return new ResultHooty(x, y, a, b);
    }