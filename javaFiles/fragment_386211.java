class ValueWithRadix implements Serializable
{
    int radix;
    String value;
}

int deserializedTwo = Integer.parseInt( valueWithRadix.getValue() , valueWithRadix.getRadix() );