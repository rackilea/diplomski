public static byte[] GetPartialHash(byte[] input, int size)
{
    var sha = new SHA1Managed();
    int offset = 0;

    while (input.Length - offset >= size)
        offset += sha.TransformBlock(input, offset, size, input, offset);

    sha.TransformFinalBlock(input, offset, input.Length - offset);
    return sha.Hash;
}