int i=0;        
for (String tmpStr: fieldNamesArr) {
   Field field = ourClass.getField(tmpStr);   

   //converting string from fieldValuesArr[i] to required type //   

   field.set(obj,value);
   i++
}