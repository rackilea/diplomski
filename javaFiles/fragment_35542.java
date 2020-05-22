long long int fast_exp(int base, int exp)
{
    if(exp==1)
    return base;
    else
    {
        if(exp%2 == 0)
        {
            long long int ret = fast_exp(base, exp/2);
            long long int base1 = ret * ret;
            return base1 % 1000000007;
        }
        else
        {
            long long int ret = fast_exp(base, (exp-1)/2);
            long long int ans = base * ret;
            ans %= 1000000007; 
            ans *= ret;
            return ans % 1000000007;
        }
    }
}

int main() {
    std::cout << fast_exp(2, 999999999) << std::endl;
    std::cout << fast_exp(2, 1000000000) << std::endl;
    return 0;
}