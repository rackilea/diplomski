Compiled from "String.java"
public final class java.lang.String implements java.io.Serializable, java.lang.Comparable<java.lang.String>, java.lang.CharSequence {
  public static final java.util.Comparator<java.lang.String> CASE_INSENSITIVE_ORDER;
    descriptor: Ljava/util/Comparator;
  public java.lang.String();
    descriptor: ()V

  public java.lang.String(java.lang.String);
    descriptor: (Ljava/lang/String;)V

  public java.lang.String(char[]);
    descriptor: ([C)V

  public java.lang.String(char[], int, int);
    descriptor: ([CII)V

  public java.lang.String(int[], int, int);
    descriptor: ([III)V

  public java.lang.String(byte[], int, int, int);
    descriptor: ([BIII)V

  public java.lang.String(byte[], int);
    descriptor: ([BI)V

  public java.lang.String(byte[], int, int, java.lang.String) throws java.io.UnsupportedEncodingException;
    descriptor: ([BIILjava/lang/String;)V

  public java.lang.String(byte[], int, int, java.nio.charset.Charset);
    descriptor: ([BIILjava/nio/charset/Charset;)V

  public java.lang.String(byte[], java.lang.String) throws java.io.UnsupportedEncodingException;
    descriptor: ([BLjava/lang/String;)V

  public java.lang.String(byte[], java.nio.charset.Charset);
    descriptor: ([BLjava/nio/charset/Charset;)V

  public java.lang.String(byte[], int, int);
    descriptor: ([BII)V

  public java.lang.String(byte[]);
    descriptor: ([B)V

  public java.lang.String(java.lang.StringBuffer);
    descriptor: (Ljava/lang/StringBuffer;)V

  public java.lang.String(java.lang.StringBuilder);
    descriptor: (Ljava/lang/StringBuilder;)V

  public int length();
    descriptor: ()I

  public boolean isEmpty();
    descriptor: ()Z

  public native char charAt(int);
    descriptor: (I)C

  public int codePointAt(int);
    descriptor: (I)I

  public int codePointBefore(int);
    descriptor: (I)I

  public int codePointCount(int, int);
    descriptor: (II)I

  public int offsetByCodePoints(int, int);
    descriptor: (II)I

  public void getChars(int, int, char[], int);
    descriptor: (II[CI)V

  public void getBytes(int, int, byte[], int);
    descriptor: (II[BI)V

  public byte[] getBytes(java.lang.String) throws java.io.UnsupportedEncodingException;
    descriptor: (Ljava/lang/String;)[B

  public byte[] getBytes(java.nio.charset.Charset);
    descriptor: (Ljava/nio/charset/Charset;)[B

  public byte[] getBytes();
    descriptor: ()[B

  public boolean equals(java.lang.Object);
    descriptor: (Ljava/lang/Object;)Z

  public boolean contentEquals(java.lang.StringBuffer);
    descriptor: (Ljava/lang/StringBuffer;)Z

  public boolean contentEquals(java.lang.CharSequence);
    descriptor: (Ljava/lang/CharSequence;)Z

  public boolean equalsIgnoreCase(java.lang.String);
    descriptor: (Ljava/lang/String;)Z

  public native int compareTo(java.lang.String);
    descriptor: (Ljava/lang/String;)I

  public int compareToIgnoreCase(java.lang.String);
    descriptor: (Ljava/lang/String;)I

  public boolean regionMatches(int, java.lang.String, int, int);
    descriptor: (ILjava/lang/String;II)Z

  public boolean regionMatches(boolean, int, java.lang.String, int, int);
    descriptor: (ZILjava/lang/String;II)Z

  public boolean startsWith(java.lang.String, int);
    descriptor: (Ljava/lang/String;I)Z

  public boolean startsWith(java.lang.String);
    descriptor: (Ljava/lang/String;)Z

  public boolean endsWith(java.lang.String);
    descriptor: (Ljava/lang/String;)Z

  public int hashCode();
    descriptor: ()I

  public int indexOf(int);
    descriptor: (I)I

  public int indexOf(int, int);
    descriptor: (II)I

  public int lastIndexOf(int);
    descriptor: (I)I

  public int lastIndexOf(int, int);
    descriptor: (II)I

  public int indexOf(java.lang.String);
    descriptor: (Ljava/lang/String;)I

  public int indexOf(java.lang.String, int);
    descriptor: (Ljava/lang/String;I)I

  public int lastIndexOf(java.lang.String);
    descriptor: (Ljava/lang/String;)I

  public int lastIndexOf(java.lang.String, int);
    descriptor: (Ljava/lang/String;I)I

  public java.lang.String substring(int);
    descriptor: (I)Ljava/lang/String;

  public java.lang.String substring(int, int);
    descriptor: (II)Ljava/lang/String;

  public java.lang.CharSequence subSequence(int, int);
    descriptor: (II)Ljava/lang/CharSequence;

  public native java.lang.String concat(java.lang.String);
    descriptor: (Ljava/lang/String;)Ljava/lang/String;

  public java.lang.String replace(char, char);
    descriptor: (CC)Ljava/lang/String;

  public boolean matches(java.lang.String);
    descriptor: (Ljava/lang/String;)Z

  public boolean contains(java.lang.CharSequence);
    descriptor: (Ljava/lang/CharSequence;)Z

  public java.lang.String replaceFirst(java.lang.String, java.lang.String);
    descriptor: (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

  public java.lang.String replaceAll(java.lang.String, java.lang.String);
    descriptor: (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

  public java.lang.String replace(java.lang.CharSequence, java.lang.CharSequence);
    descriptor: (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

  public java.lang.String[] split(java.lang.String, int);
    descriptor: (Ljava/lang/String;I)[Ljava/lang/String;

  public java.lang.String[] split(java.lang.String);
    descriptor: (Ljava/lang/String;)[Ljava/lang/String;

  public java.lang.String toLowerCase(java.util.Locale);
    descriptor: (Ljava/util/Locale;)Ljava/lang/String;

  public java.lang.String toLowerCase();
    descriptor: ()Ljava/lang/String;

  public java.lang.String toUpperCase(java.util.Locale);
    descriptor: (Ljava/util/Locale;)Ljava/lang/String;

  public java.lang.String toUpperCase();
    descriptor: ()Ljava/lang/String;

  public java.lang.String trim();
    descriptor: ()Ljava/lang/String;

  public java.lang.String toString();
    descriptor: ()Ljava/lang/String;

  public native char[] toCharArray();
    descriptor: ()[C

  public static java.lang.String format(java.lang.String, java.lang.Object...);
    descriptor: (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

  public static java.lang.String format(java.util.Locale, java.lang.String, java.lang.Object...);
    descriptor: (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

  public static java.lang.String valueOf(java.lang.Object);
    descriptor: (Ljava/lang/Object;)Ljava/lang/String;

  public static java.lang.String valueOf(char[]);
    descriptor: ([C)Ljava/lang/String;

  public static java.lang.String valueOf(char[], int, int);
    descriptor: ([CII)Ljava/lang/String;

  public static java.lang.String copyValueOf(char[], int, int);
    descriptor: ([CII)Ljava/lang/String;

  public static java.lang.String copyValueOf(char[]);
    descriptor: ([C)Ljava/lang/String;

  public static java.lang.String valueOf(boolean);
    descriptor: (Z)Ljava/lang/String;

  public static java.lang.String valueOf(char);
    descriptor: (C)Ljava/lang/String;

  public static java.lang.String valueOf(int);
    descriptor: (I)Ljava/lang/String;

  public static java.lang.String valueOf(long);
    descriptor: (J)Ljava/lang/String;

  public static java.lang.String valueOf(float);
    descriptor: (F)Ljava/lang/String;

  public static java.lang.String valueOf(double);
    descriptor: (D)Ljava/lang/String;

  public native java.lang.String intern();
    descriptor: ()Ljava/lang/String;

  public int compareTo(java.lang.Object);
    descriptor: (Ljava/lang/Object;)I

  static {};
    descriptor: ()V
}