{
    int[] hidden_array_ref = indexes;
    int hidden_length = hidden_array_ref.length;
    for(int hidden_counter = 0; hidden_counter < hidden_length; hidden_counter++) {
        int j = hidden_array_ref[hidden_counter];
        sb.append(array[j] ? '1' : '0');
    }
}