List<ArrayList<Integer>> vector1 = new ArrayList<ArrayList<Integer>>();
List<ArrayList<Integer>> vector2 = new ArrayList<ArrayList<Integer>>();

ArrayList<Integer> tmp = new ArrayList<Integer>();
tmp.add(1000);
tmp.add(0);
tmp.add(100100);
tmp.add(1);
vector1.add(tmp);
tmp = new ArrayList<Integer>();
tmp.add(1000);
tmp.add(1);
tmp.add(100100);
tmp.add(1);
vector1.add(tmp);
tmp = new ArrayList<Integer>();
tmp.add(1002);
tmp.add(2);
tmp.add(100100);
tmp.add(1);
vector1.add(tmp);

tmp = new ArrayList<Integer>();
tmp.add(1000);
tmp.add(0);
tmp.add(100102);
tmp.add(2);
vector2.add(tmp);
tmp = new ArrayList<Integer>();
tmp.add(1000);
tmp.add(1);
tmp.add(100100);
tmp.add(1);
vector2.add(tmp);

System.out.println(vector1);
System.out.println(vector2);

Integer[] vec3 = new Integer[2];
Integer[] vec4 = new Integer[2];
boolean flag = false;

for (ArrayList<Integer> vec1Tmp : vector1) {
    flag = false;
    vec3[0] = vec1Tmp.get(0);
    vec3[1] = vec1Tmp.get(1);

    for (ArrayList<Integer> vec2Tmp : vector2) {
        vec4[0] = vec2Tmp.get(0);
        vec4[1] = vec2Tmp.get(1);

        if ( Arrays.equals(vec3, vec4) ) {
            flag = true;
            break;
        }

    }

    if ( !flag ) {
        // do your deletion here
        System.out.println(vec1Tmp);
    }
}