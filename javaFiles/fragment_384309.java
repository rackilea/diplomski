class WifiData implements Comparable<WifiData> {
    String SSID;

    public String getSSID() {
        return SSID;
    }

    @Override
    public int compareTo(WifiData o) {
        return this.SSID.compareTo(o.getSSID());
    }

    public Comparable[] qsort(Comparable[] array, int left, int right){
        int ll=left;
        int rr=right;

        if (rr>ll){
            Comparable pivot = array[(ll+rr)/2];
            while (ll <=rr){
                while(ll<right && array[ll].compareTo(pivot) < 0){
                    ll +=1;
                }
                while(rr>left && array[rr].compareTo(pivot) > 0){
                    rr -=1;
                }
                if (ll <=rr){
                    swap(array, ll ,rr);
                    ll +=1;
                    rr -=1;
                }
            }
            if (left < rr){
                qsort(array,left,rr);

            }
            if (ll<right){
                qsort(array,ll,right);
            }
        }
        return array;
    }

    void swap(Comparable[] arr, int l, int r) {
        Comparable t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}