STATE ENTERED: SI
STAGE TRANSITIONS From: null To: SI
STATE EXITED: SI
STATE ENTERED: F1
STAGE TRANSITIONS From: SI To: F1
21:45:39.153 [pool-2-thread-1] DEBUG org.springframework.statemachine.support.AbstractStateMachine - Queue event GenericMessage [payload=E2, headers={id=393a5636-a760-57d6-a98b-d31eb75f048e, timestamp=1560969939152}] SF F2 F1 SI  / F1 / uuid=4e8773c1-e755-40de-b431-e53a4b0ca64d / id=null
STATE EXITED: F1
STATE ENTERED: F2
STAGE TRANSITIONS From: F1 To: F2
21:45:39.161 [pool-2-thread-1] DEBUG org.springframework.statemachine.support.AbstractStateMachine - Queue event GenericMessage [payload=E3, headers={id=f5899e8b-e4a5-e079-3a30-66114a7accac, timestamp=1560969939161}] SF F2 F1 SI  / F2 / uuid=4e8773c1-e755-40de-b431-e53a4b0ca64d / id=null
Completing SM!
STATE EXITED: F2
STATE ENTERED: SF
STAGE TRANSITIONS From: F2 To: SF