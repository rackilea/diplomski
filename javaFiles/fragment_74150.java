X = bsxfun(@minus, trainingData, mean(trainingData,1));           
covariancex = (X'*X)./(size(X,1)-1);                 

[V D] = eigs(covariancex, 10);   % reduce to 10 dimension

Xtest = bsxfun(@minus, test, mean(trainingData,1));  
pcatest = Xtest*V;