int count[] = new int[Length];
for(int i = 0; i < 20; i++) {
    count[a[i]]++;
}

for(int i = 0; i < 20; i++) {
    if(count[i] > 1)
        System.out.println(i);
}