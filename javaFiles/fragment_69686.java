boolean seen[65536];
StringBuilder res = new StringBuilder();
str = str.toUpperCase();
for (char c : str.toCharArray()) {
    if (!seen[c]) res.append(c);
    seen[c] = true;
}
return res.toString();