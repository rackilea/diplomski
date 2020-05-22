// Get all StackOverflow users with more than 20,000 reputation points.
val topUsers = for{
    u <- users
    if u.reputation > 20000
} yield u;

println ("Users with more than 20,000 reputation:")
for (u <- topUsers) {
    println u.name
}