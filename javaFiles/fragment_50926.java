final class DBGlobalsException extends Exception
{
   Field somethingDBGlobalsSpecific;

   //where this is shorthand for chained constructors that look like Exception
   DBGlobalsException(String message, Throwable cause)
   {
     super(message,cause);
   }

   // elaborate your exception with whatever error state you want to propagate outwards
   void setField(Field ...) {}
}