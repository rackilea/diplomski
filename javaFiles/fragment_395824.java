int n, m;
int ndivisorsSum = 0;
int mdivisorsSum = 0;

n = 220;
m = 284;

for(int i = 1; i < n; i++){
    if (n % i == 0){
        ndivisorsSum += i;
    }
}

for(int i = 1; i < m; i++){
    if (m % i == 0){
        mdivisorsSum += i;
    }
}

if (ndivisorsSum == m && mdivisorsSum == n) { // Your mistake is here.
    System.out.println(n + " and " + m + " are amicable numbers");
}else{
    System.out.println(n + " and " + m + " are not amicable numbers");
}