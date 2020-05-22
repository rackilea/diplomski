Relation<? extends NumberVector> rel = ...;
NumberDistanceFunction df = SquaredEuclideanDistanceFunction.STATIC;

... run the algorithm, then iterate over each cluster: ...

Cluster<KMeansModel> cluster = ...;
Vector center = cluster.getModel().getMean(); 
double varsum = cluster.getModel().getVarianceContribution();

double sum = 0.;
// C++-style for loop, for efficiency:
for(DBIDRef id = cluster.getIDs().iterDBIDs(); id.valid(); id.advance()) {
   double distance = df.distance(relation.get(id), center);
   sum += distance;
}

System.out.println(varsum+" should be the same as "+sum);