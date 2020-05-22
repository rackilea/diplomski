Tsp.point[] nodeptr = new Tsp.point[Input.General_Inputs.N];

    for(int i=0;i<Input.General_Inputs.N_O_P;i++){
      nodeptr[i] = new Tsp.point();
      nodeptr[i].x = P[i];
      nodeptr[i].y = C[i];
      nodeptr[i].z = L[i];
    }