public static List<String> descriptorToBinary(List<Double> desc){

    List<String> binary_desc = new ArrayList<String>();

    String desc_bin= "";
    for(int i = 0; i < desc.size(); i++){

        String binary_str_tmp = Integer.toBinaryString((int)((double)desc.get(i)));
        if (binary_str_tmp.length() < 16)
        {
            int number_of_zeros = 16 - binary_str_tmp.length();
            String str_tmp = "";
            for(int t = 0; t < number_of_zeros; t++){
                str_tmp += "0";
            }
            binary_str_tmp = str_tmp + binary_str_tmp;
        }

        desc_bin+= binary_str_tmp;
        binary_desc.add(final_binary_str);

    }

    return binary_desc;

}