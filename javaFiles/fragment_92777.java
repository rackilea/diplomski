String input = "Das Polaritätsprofil für das Wort \"Hund\" als Testeinheit " +
               "könnte zeigen , dass verschiedene Personen unterschiedliche " +
               "Einstellungen zu diesen Tieren haben .";

Map<Character, int[]> countMap = new HashMap<>();
for (Character ch : input.toCharArray()) {
    int[] counter = countMap.get(ch);
    if (counter == null)
        countMap.put(ch, new int[] { 1 });
    else
        counter[0]++;
}
@SuppressWarnings("unchecked")
Entry<Character, int[]>[] counts = countMap.entrySet().toArray(new Map.Entry[countMap.size()]);
Collator collator = Collator.getInstance(Locale.GERMAN);
Arrays.sort(counts, (e1, e2) -> collator.compare(e1.getKey().toString(), e2.getKey().toString()));
for (Entry<Character, int[]> entry : counts)
    System.out.printf("%c - %d%n", entry.getKey(), entry.getValue()[0]);