interface Component<SELF extends Component<SELF>> { Set<Connector<?, SELF>> getIns();...}

interface Connector<SOURCE extends Component<SOURCE>, DESTINATION extends Component<DESTINATION>> { SOURCE getSource();...}

interface CompA extends Component<CompA> {}

interface CompB extends Component<CompB> {}

interface A_A extends Connector<CompA, CompA> {}

interface A_B extends Connector<CompA, CompB> {}