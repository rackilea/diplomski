public static long argbToLong(int a, int r, int g, int b)
{
    new[] { a, r, g, b }.Select((v, i) => new { Name = "argb"[i].ToString(), Value = v }).ToList()
        .ForEach(arg =>
        {
            if (arg.Value > 255 || arg.Value < 0)
                throw new ArgumentOutOfRangeException(arg.Name, arg.Name + " must be between or equal to 0-255");
        });
    long al = (a << 24) & 0xFF000000;
    long rl = (r << 16) & 0x00FF0000;
    long gl = (g << 8) & 0x0000FF00;
    long bl = b & 0x000000FF;
    return al | rl | gl | bl;
}

public static Tuple<int, int, int, int> longToArgb(long argb)
{
    var max = Math.Pow(16, 8) - 1;
    if (argb < 0 || argb > max)
        throw new ArgumentOutOfRangeException("argb", "argb must be between or equal to 0-" + max);
    int a = (int)((argb & 0xFF000000) >> 24);
    int r = (int)((argb & 0x00FF0000) >> 16);
    int g = (int)((argb & 0x0000FF00) >> 8);
    int b = (int)(argb & 0x000000FF);
    return new Tuple<int, int, int, int>(a, r, g, b);
}