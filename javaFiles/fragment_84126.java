DashboardObjectAIR[] airObj = new DashboardObjectAIR[2];
    airObj[0] = new DashboardObjectAIR("UnOk");
    airObj[1] = new DashboardObjectAIR("Ok");
    DashboardObjectAIR[] airObj1 = new DashboardObjectAIR[2];
    airObj1[0] = new DashboardObjectAIR("Ok");
    airObj1[1] = new DashboardObjectAIR("Ok");
    DashboardObjectAIR[] airObj3 = new DashboardObjectAIR[2];
    airObj3[0] = new DashboardObjectAIR("Ok");
    airObj3[1] = new DashboardObjectAIR("Ok");
    DashboardObjectAIR[] airObj4 = new DashboardObjectAIR[2];
    airObj4[0] = new DashboardObjectAIR("Ok");
    airObj4[1] = new DashboardObjectAIR("UnOk");

    List<DashboardObjectAIR[]> listOfArray = new ArrayList<DashboardObjectAIR[]>();
    listOfArray.add(airObj);
    listOfArray.add(airObj1);
    listOfArray.add(airObj3);
    listOfArray.add(airObj4);

    Comparator<DashboardObjectAIR[]> c = (a1, a2) -> {
        int comp = a2[0].getOk().compareTo(a1[0].getOk()); // note a2 - a1 to have Unok before Ok
        if (comp == 0)
            return a2[1].getOk().compareTo(a1[1].getOk());
        else
            return comp;
    };
    List<DashboardObjectAIR[]> sorted = listOfArray.stream().sorted(c).collect(Collectors.toList());
    sorted.forEach(arr -> System.out.println(Arrays.toString(arr)));