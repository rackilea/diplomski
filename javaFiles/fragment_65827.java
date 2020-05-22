String[] arr = {"T1", "C1", "C2", "T2", "C3", "T3", "A1", "T4", "G1", "A2", "G2", "A3", "T5",
    "C4", "C5", "T6", "A4", "T7", "T8", "C6", "T9", "A5", "T10", "G3", "A6", "A7", "A8", "C7",
    "C8", "T11", "T12", "C9", "A9", "$1", "G4", "A10", "C10", "C11", "A11", "A12", "A13",
    "A14", "T13", "T14", "C12", "T15", "C13", "C14", "G5", "G6", "C15"};
Arrays.sort(arr, Comparator.<String, Character>comparing(s -> s.charAt(0))
    .thenComparingInt(s -> Integer.parseInt(s.substring(1))));
System.out.println(Arrays.toString(arr));