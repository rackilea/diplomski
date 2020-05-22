StringBuilder out = new StringBuilder();
int j=0;
for (int i = 0; i< mask.lenght ;  i++) {
   if (mask[i] == 'X') {
       out.append(producNumber[j];
       j++;
   }
   else {
       out.append('.');
       i++;
   }
}
return out.toString();