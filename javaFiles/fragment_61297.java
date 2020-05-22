if (unoccupied.isEmpty()) throw something;
int i = random.nextInt(unoccupied.size());
Iterator<Pos> iter = unoccupied.iterator();
while (i-- > 0)
    iter.next();
return iter.next();