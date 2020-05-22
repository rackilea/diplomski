Set<String> set = new HashSet<>(Arrays.asList("knee", "leg", "ankle", "thumb", "wrist"));

String lower = "broken right thumb".toLowerCase();
String split[] = lower.split(" ");
if (lower.contains("broken") && Arrays.stream(split).anyMatch(set::contains)) {
    System.out.println("Marvin sends in the backup quarterback.");
}