Item[] items = ...;

// Compute the total weight of all items together
double totalWeight = 0.0d;
for (Item i : items)
{
    totalWeight += i.getWeight();
}
// Now choose a random item
int randomIndex = -1;
double random = Math.random() * totalWeight;
for (int i = 0; i < items.length; ++i)
{
    random -= items[i].getWeight();
    if (random <= 0.0d)
    {
        randomIndex = i;
        break;
    }
}
Item myRandomItem = items[randomIndex];