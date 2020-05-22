String value = "Thistestistestatesttest";
String input = "test";

int offset = 0;
int matches = 0;
for (char next : value.toCharArray()) {
    if (next == input.charAt(offset)) {
        offset++;
        if (offset == input.length()) {
            matches++;
            offset = 0;
        }
    } else {
        offset = 0;
    }
}
System.out.println("Found " + matches);