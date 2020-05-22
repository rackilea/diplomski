private void createMap(){
  for(int i=0;i<this.stateActionTable.length;i++){
    List<Integer> state_action_pair = new ArrayList<Integer>();
    for(int j=0;j<this.stateActionTable[0].length;j++){
        state_action_pair.add(this.stateActionTable[i][j]);
    }
    this.stateActionMap.put(state_action_pair, i);
}