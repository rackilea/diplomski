class WifiData {
    String SSID;

    public String getSSID() {
        return SSID;
    }

    // example how to use it
    public static void main(String[] args) {
        Comparator<WifiData> comp = new SSIDComparator();
        WifiData[] arr = new WifiData[10];
        // ... fill the array
        arr = qsort(arr, 0, arr.length-1, comp);        
    }

    public static WifiData[] qsort(WifiData[] array, 
                                    int left, 
                                    int right,                        
                                    Comparator<WifiData> comp){
        int ll=left;
        int rr=right;

        if (rr>ll){
            WifiData pivot = array[(ll+rr)/2];
            while (ll <=rr){
                // that's how we'll use the comparator:
                while(ll<right && comp.compare(array[ll], pivot) < 0){
                    ll +=1;
                }
                while(rr>left &&  comp.compare(array[rr], pivot) > 0){
                    rr -=1;
                }
                if (ll <=rr){
                    swap(array, ll ,rr);
                    ll +=1;
                    rr -=1;
                }
            }
            if (left < rr){
                qsort(array,left,rr, comp);

            }
            if (ll<right){
                qsort(array, ll, right, comp);
            }
        }
        return array;
    }    

    // an example of Comparator that sorts by SSID
    static class SSIDComparator implements Comparator<WifiData>{
        @Override
        public int compare(WifiData o1, WifiData o2) {
            return o1.getSSID().compareTo(o2.getSSID());
        }
    }
}