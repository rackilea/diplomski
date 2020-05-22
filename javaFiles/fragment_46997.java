for (Enemy en : enemies)
{
    if (en.isDead() == true)
    {
        // Remove en from enemies. 
        // You'll probably need to use a "for" here keeping track of the last 
        // element when deleting one. So you can continue checking/updating 
        // enemies.
        continue;
    }
    en.update();
}