if (Encounter ().equals ("Attack"))
{
  String attack = pikaAtkType (); 
  if (attack.equals ("Tackle"))
  {
    pikaDMG = 3;
  }
  else if (attack.equals ("Thunder Shock"))
  {
    pikaDMG = 4;
  }