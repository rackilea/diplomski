final class Ligatures {
  public static CharSequence compose ( CharSequence decomposedCharacters );
  public static CharSequence decompose ( CharSequence composedCharacters );
}

interface LigatureDecoder {
  CharSequence decompose ( CharSequence composedCharacters );
}

interface LigatureEncoder {
  CharSequence compose ( CharSequence decomposedCharacters );
}