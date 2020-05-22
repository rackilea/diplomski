public static void main(String[] args) {
        String[] arr = new String[]{"FIRST", "SECOND", "SECOND", "THIRD", "FOURTH", "FIRST", "FOURTH"};
        String[] toRemove = new String[]{"FIRST","SECOND"};
        arr=removeSuccessive(arr,toRemove);
        System.out.println(Arrays.toString(arr));
    }

    private static String[] removeSuccessive(String[] arr, String[] toRemove) {
        ArrayList<String> res=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(toRemove[0]))
                    res.add(arr[i]);
            else if(i+1<arr.length && !arr[i+1].equals(toRemove[1]))
                    res.add(arr[i]);
            else
                i++;
        }

        return res.toArray(new String[res.size()]);
    }