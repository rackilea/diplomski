for (List<String> list : run.accounts) {
        if ((list.get(0).compareTo(id) == 0) && (list.get(0).compareTo(p) == 0)) {
            auth = true;
            System.out.println(auth);
            break;
        }else {
            auth = false;
            System.out.println(auth);
        }
    }