a = new int[total+1]
for int j = 1 to total+1 {
    a[j] = infinity
}
for int coin in coins {
    for j = coin to total+1 {
        a[j] = min(a[j], a[j-coin]+1)
    }
}