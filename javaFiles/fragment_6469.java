public int whatIstheIndex(char c) {

        for (int i = 0; i < _st.length(); i++)

            if (_st.charAt(i) == c) {
                return i;
            } 

        return -1;

    }