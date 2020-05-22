String name = ...
  List vms = VirtualMachine.list();
  for (VirtualMachineDescriptor vmd: vms) {
      if (vmd.displayName().equals(name)) {
          VirtualMachine vm = VirtualMachine.attach(vmd.id());
          String agent = ...
          vm.loadAgent(agent);
          // ...
      }
  }