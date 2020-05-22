"WORD abc".matches(".*?(?<=\\s|^)WORD(?=\\s|$).*"); // true

"WORD".matches(".*?(?<=\\s|^)WORD(?=\\s|$).*"); // true

"WORD-abc".matches(".*?(?<=\\s|^)WORD(?=\\s|$).*"); // false

"some-WORD".matches(".*?(?<=\\s|^)WORD(?=\\s|$).*"); // false