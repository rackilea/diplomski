internal class MQMarshalMessageForPut : MQBaseObject
{
   ...

   private void SetContent(RFH2Folder element, object value)
   {
       ...

       if (value is bool)
       {
           element.SetContent(value.ToString(), 1);
       }

       ...
    }
}