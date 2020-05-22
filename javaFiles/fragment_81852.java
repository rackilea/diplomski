String s = "test";
        Stack st = new Stack(s.length());

        for(char c : s.toCharArray())
            st.push(c);

        for(int i = 0; i <st.getSize();i++)
            System.out.print(st.pop());