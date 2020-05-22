byte[] bytes = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
for (int count = 1; count <= bytes.Length; count++)
{
    var hashA = bytes.Take(count).Aggregate(31, (i, b) => i*31 + b);
    var hashB = bytes.Take(count).Aggregate(397, (i, b) => (i*397) ^ b);
    var hashC = bytes.Take(count).Aggregate(0xfedcbabc, (i, b) => (i*397) ^ b);
    var hashD = bytes.Take(count).Aggregate(0xfedcbabc, (i, b) => (i*31) + b);
    Console.WriteLine(hashA.ToString("X8") + " / " + hashB.ToString("X8") + " / " + hashC.ToString("X8") + " / " + hashD.ToString("X8"));
}