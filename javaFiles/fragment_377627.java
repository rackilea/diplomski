bool inputIsValid( int input, int min, int max )
{
  if ( input==max )
    return true;
  int remain = max - input;
  return input>=min && remain>=min && input<max;
}