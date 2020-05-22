public void SpawnPlayers()
{
    for (Player spawnPlayer : players)
    {
        if (spawnPlayer.getCharacter().getCanSpawn())
        {
            ...
        }
    }
}