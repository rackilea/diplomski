@Override
public int hashCode() {
    int result = 17;
    result = 31 * result + characterwiseCaseNormalize(getFirstName()).hashCode();
    result = 31 * result + characterwiseCaseNormalize(getLastName()).hashCode();
    return result;
}

private static String characterwiseCaseNormalize(String s) {
    StringBuilder sb = new StringBuilder(s);
    for(int i = 0; i < sb.length(); i++) {
        sb.setCharAt(i,Character.toLowerCase(Character.toUpperCase(sb.charAt(i))));
    }
    return sb.toString();
}