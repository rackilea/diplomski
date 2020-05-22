public boolean checkString(String value)
{
boolean found = false;

for(String searchcontent:searchNames)
{
if((searchcontent).equalsIgnoreCase(value))
{
                found = true;
                break;
            }

        }


        return found;
}