public class RandomNumbersStreamReader : StreamReader {
    private Random random = new Random();

    public String ReadLine() { return random.Next().ToString(); }
}

// and to call it:
int x = ReadInt(new RandomNumbersStreamReader());