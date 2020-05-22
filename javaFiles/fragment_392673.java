String str = "It is situated near the Bara Imambara and on the connecting road stands an imposing gateway known as Rumi Darwaza. The building is also known as the Palace of Lights because of its decorations and chandeliers during special festivals, like Muharram";
int index = str.indexOf("Rumi Darwaza");
Matcher m = Pattern.compile("\\s(\\S+)\\s(\\S+)\\s(\\S+)\\s*$").matcher(str.substring(0, index));
if (m.find() && m.groupCount() == 3) {
    for (int i = 1 ; i <= 3 ; i++) {
        System.out.println(m.group(i));
    }
}