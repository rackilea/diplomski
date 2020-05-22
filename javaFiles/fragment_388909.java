@Override
public boolean equals(Object other)
{
    if (!(other instanceof Player))
        return false;
    Player op = (Player) other;
    return id == op.id;
}