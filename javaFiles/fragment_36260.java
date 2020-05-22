char row = 'B';
char columnStart = 'A';
char columnEnd = 'M';

for (char column = columnStart; columnStart <= columnEnd; column++) {
    String key = Chararcter.toString(row) + column;
    String data = map.get(key);
    ...
}