Mat Mi2 = var1.row(i);
Mat result = new Mat();
normSum = norm(Mi2, NORM_L2);
//advice: remember to avoid or not if normSum == 0.0
Scalar scalar = new Scalar(1.0/normSum);
Core.multiply(Mi2, scalar, result);
var1.row(i) = result;