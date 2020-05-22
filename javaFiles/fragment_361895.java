public void dispatch(Object o)
{
   if (o instanceof String)
       handleString((String)o);
   else if (o instanceof File)
       handleFile((File)o);
   else
       handleObject(o);
}