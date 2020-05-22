for (int i = 0; i < 20; i++) {
    set1.set(i, r.nextBoolean());
    set2.set(i, r.nextBoolean());
}

...

for (int i = 0; i < 20; i++) {
    s.append(temp1.get(i) == true ? 1 : 0);
}