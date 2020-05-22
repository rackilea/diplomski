// Intersect 2 endless lines
// line 1: "P" is on endless line, the direction is "dir1" ("R")
// line 2: "Q" is on endless line, the direction is "dir2" ("S")
PVector Intersect( PVector P, PVector dir1, PVector Q, PVector dir2) {

    PVector R = dir1.copy();
    PVector S = dir2.copy();
    R.normalize();
    S.normalize();

    PVector QP  = PVector.sub(Q, P);
    PVector SNV = new PVector(S.y, -S.x);

    float t  =  QP.dot(SNV) / R.dot(SNV); 

    PVector X = PVector.add(P, PVector.mult(R, t));
    return X;
}