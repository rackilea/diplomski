String c[] = new String[Ques_low];
        String cAns[] = new String[Ques_low];

        for (int i = 0; i < Ques_low; i++) {
            c[i] = (String) request.getParameter("" + i);
            cAns[i] = (String) session.getAttribute("" + i);
            out.println(Arrays.asList(c).containsAll(Arrays.asList(cAns)));
        }