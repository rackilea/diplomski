// ☻+00000001B♥
char stx = m_dWeight.charAt(0);
char etx = m_dWeight.charAt(11);
if (stx == 2 && etx == 3) {
    long actualValue = Long.parseLong(m_dWeight.substring(1, 11), 16);
    System.out.println(actualValue);
}