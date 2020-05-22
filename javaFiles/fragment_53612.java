/**
 * Different from other values, Strings need quoting
 */
@Override
public String toString()
{
    int len = _value.length();
    len = len + 2 + (len >> 4);
    return new StringBuilder(len)
            // 09-Dec-2017, tatu: Use apostrophes on purpose to prevent use as JSON producer:
            .append('\'')
            .append(_value)
            .append('\'')
            .toString();
}