Problem problem = new Problem();
problem.l = 5;
problem.n = 3;
problem.x = new FeatureNode[][] {
  new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(2, 1) },  
  new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(2, 1) },  
  new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(2, 1) },  
  new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(2, 1) },  
  new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(3, 1) },  
};
problem.y = new int[] {0, 0, 0, 0, 1};

Parameter parameter = new Parameter(SolverType.L2R_L2LOSS_SVC, 1.0, 0.01);
Model model = Linear.train(problem, parameter);
FeatureNode[] instance = new FeatureNode[] { new FeatureNode(1, 1), new FeatureNode(4, 1) };
int prediction = Linear.predict(model, instance);