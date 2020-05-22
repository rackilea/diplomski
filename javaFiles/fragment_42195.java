digraph J48Tree {
N0 [label="outlook" ]
N0->N1 [label="= sunny"]
N1 [label="humidity" ]
N1->N2 [label="<= 75"]
N2 [label="yes (2.0)" shape=box style=filled ]
N1->N3 [label="> 75"]
N3 [label="no (3.0)" shape=box style=filled ]
N0->N4 [label="= overcast"]
N4 [label="yes (4.0)" shape=box style=filled ]
N0->N5 [label="= rainy"]
N5 [label="yes (4.0/1.0)" shape=box style=filled ]
}