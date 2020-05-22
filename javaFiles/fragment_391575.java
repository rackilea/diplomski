public static String printDIV(ArrayList<FoundObject> objects)
    {
        String result = "";
        Iterator<FoundObject> it = objects.iterator();
        FoundObject fo;

        while(it.hasNext())
        {
            fo = it.next();

            if(fo instanceof FoundCharObject)
            {
                FoundCharObject fc = (FoundCharObject)fo;
                result+=fc.getChar();
            }

            if(fo instanceof FoundBoxObject)
            {
                result+="<div>";
                FoundBoxObject fb = (FoundBoxObject)fo;
                result+=printDIV(fb.containedObjects);
                result+="</div>";
            }           
        }

        return result;
    }