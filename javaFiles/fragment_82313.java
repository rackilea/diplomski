public class StringTestProgram {
    public static void main(String[] args) {
        String relativeDN = "cn=abc,dn=xyz,ou=abc/def";

        String[] stringData = relativeDN.split(",");

        StringBuilder sb = new StringBuilder(); 
        CharSequence charAdded = ",";

        for (int i = 0; i < stringData .length; i++) { //walk over each element of the array
            System.out.println(stringData[i]);
            sb.append(stringData[i]); // append element to the StringBuilder

            if (i < stringData.length - 1) //avoids adding an extra ',' at the end
                sb.append(charAdded); // if not at the last element, add the ',' character
        }

        System.out.print(sb.toString()); 
    }
}