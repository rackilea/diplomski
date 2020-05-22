public PlayerShip()
{
    position = Global.promptInt("Player position: ");
    gun1 = new Gun(position - 1, 5);
    gun2 = new Gun(position + 1, 5);
}

public void Move(int distance)
{
    position = position + distance;

    gun1.Move(distance);
    gun1.Move(distance);

}