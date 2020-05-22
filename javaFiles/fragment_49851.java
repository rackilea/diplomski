public double sumSelectedValues() {
     double ans = 0;
     for(int i : eoList.getSelectedIndices()) {
         ans += eo_values[i];
     }
     return ans;
 }