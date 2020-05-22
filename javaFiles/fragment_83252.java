// offset = 0, count = 6, backing array = { 'F', 'O', 'O', 'B', 'A', 'R' }
String original = "FOOBAR";

// offset = 1, count = 2, backing array = { 'F', 'O', 'O', 'B', 'A', 'R' }
String substring = original.substring(2);

// offset = 0, count = 2, backing array = { 'O', 'O' }
String trimmed = new String(substring);