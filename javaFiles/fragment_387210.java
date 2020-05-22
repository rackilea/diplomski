getTokens("conf=0ticket[0,9]=\"TEST\"config={0,0,0}platform_id=121212");
=> <conf=0>
=> <ticket[0,9]="TEST">
=> <config={0,0,0}>
=> <platform_id=121212>

getTokens("na23me=12341234las4tName={{0,0,0},{0,0,0},{0,0,0}}stree2t[696]=764545457OK");
=> <na23me=12341234>
=> <las4tName={{0,0,0},{0,0,0},{0,0,0}}>
=> <stree2t[696]=764545457>
=> <OK>

getTokens("na23me=12341234las4tName=654567stree2t[696]=764545457OK");
=> <na23me=12341234>
=> <las4tName=654567>
=> <stree2t[696]=764545457>
=> <OK>