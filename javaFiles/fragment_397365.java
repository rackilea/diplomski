@Autowired
public Gui(NetManager netManager) {
  this.netManager = netManager;
  netManager.init("Username");
            ...
}