Model model = new Model("Resource Allocation Problem");
    // here we are using number_of_sth+1 because we need to use a scalar function of choco
    // that will calculate sum(arr[i] * arr2[i]) and we need to specify the lack of PM
    // assignment by the 0 in them so that we can add a constraint later to prevent such
    // a happening (not assigning a VM to a PM)

    int[] VMcpu = new int[number_of_vms+1];
    int[] VMram = new int[number_of_vms+1];
    VMcpu[0] = 0;
    VMram[0] = 0;
    for (int i=1; i<number_of_vms+1; i++) {
        VMcpu[i] = vms.get(i-1).get_cpu();
        VMram[i] = vms.get(i-1).get_ram();
    }
    System.out.println();

    int[] PMcpu = new int[number_of_pms+1];
    int[] PMram = new int[number_of_pms+1];
    PMcpu[0] = 0;
    PMram[0] = 0;
    for (int i=1; i<number_of_pms+1; i++) {
        PMcpu[i] = pms.get(i-1).get_cpu();
        PMram[i] = pms.get(i-1).get_ram();
    }

    IntVar[] VMS = model.intVarArray("VMS", number_of_vms, 0, number_of_pms);

    // capacity constraints
    BoolVar[][] VMi_hosted_by_PMj = model.boolVarMatrix(number_of_pms+1, number_of_vms+1);

    for (int i=0; i<number_of_vms; i++) {
        model.arithm(VMS[i], "!=", 0).post();
    }

    for (int pm_i=1; pm_i<number_of_pms+1; pm_i++) {
        for (int vm_i=1; vm_i<number_of_vms+1; vm_i++) {
            // below is the functionality for 2 lines below
            // reifyXeqC(X, C, A) => (X == C) ? A=1 : A=0;
            model.reifyXeqC(VMS[vm_i-1], pm_i, VMi_hosted_by_PMj[pm_i][vm_i]);
        }
    }

    // here is the constraint to make sure the total VMs assigned to a PM
    // demand less that the PM's resources
    for (int i=1; i<number_of_pms+1; i++) {
        model.scalar(VMi_hosted_by_PMj[i], VMcpu, "<=", PMcpu[i]).post();
        model.scalar(VMi_hosted_by_PMj[i], VMram, "<=", PMram[i]).post();
    }

    // a constraint to have a number of PMs
    IntVar no_of_PM = model.intVar("#PM", 0, number_of_pms+1);

    // here we link the no_of_PM to the count of unique values in VMS (basically we
    // get a number of used PMs)
    model.nValues(VMS, no_of_PM).post();

    model.setObjective(false, no_of_PM); //false => model.MINIMIZE

    // here we define the array that will hold the final allocation vector (basically
    // we get a copy of VMS' values so that we have it later)
    int[] vm_alloc = new int[number_of_vms];
    int no_of_allocated_pms = number_of_pms;

    while(model.getSolver().solve()) {
        for (int i = 0; i < number_of_vms; i++) {
            vm_alloc[i] = VMS[i].getValue();
        }

        System.out.println("Number of used PMs: " + (no_of_PM.getValue()));
        no_of_allocated_pms = no_of_PM.getValue();

    }