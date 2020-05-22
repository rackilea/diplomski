public static string ToBase64ForUrlString(byte[] input)
    {
        StringBuilder result = new StringBuilder(Convert.ToBase64String(input).TrimEnd('='));
        result.Replace('+', '-');
        result.Replace('/', '_');
        return result.ToString();
    }