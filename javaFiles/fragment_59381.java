char *name;
char * age;
char * country;
point=strtok(str, "#");
if(point != NULL)
{
  name = strdup(point);
  point = strtok(NULL, "#");
  if(point != NULL)
  {
    age = strdup(point);
    point = strtok(NULL, "#");
    if(point != NULL)
    {
      country = strdup(point);
    }
  }
}