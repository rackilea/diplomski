Matrix4* Matrix4::FindInverse(Matrix4 &a){

int n = R;
int i = 0;
int j = 0;
float pivot = 0;
Matrix4* invA = NULL;
//TODO: Check whether the matrix is invertible.Else Return
invA = new Matrix4();
invA->SetMatrix4(1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1);


for(i = 0; i < n; i++){
    pivot = a.v[i][i];

    if(pivot != 1.0 and pivot != 0){
        for(int t = i; t < n; t++){
            a.v[i][t] = a.v[i][t]/pivot;
            invA->v[i][t] = invA->v[i][t]/pivot;
        }
    }

    //Update to the new pivot which must be 1.0
    pivot = a.v[i][i];

    for(j = 0; j < n; j++){
        if( j==i ){
            continue;

        }
        else{
            float l = a.v[j][i]/pivot;
            for(int m = 0; m < n; m++){
                a.v[j][m] = a.v[j][m] - l * a.v[i][m];
                invA->v[j][m] = invA->v[j][m] - (l * invA->v[i][m]);
            }
        }
    }
}
return invA;