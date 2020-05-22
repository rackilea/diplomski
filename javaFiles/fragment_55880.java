int maxSum = Int32.MinValue;
        int sum = 0;

            for (int i = 0; i < a.Length; i++)
            {
                if (a[i] >= 0)
                {
                    sum += a[i];
                    maxSum = Math.Max(sum, maxSum);

                    if ((i+1<a.Length) && (a[i+1] < a[i]))
                        sum = 0;
                }
                else
                {
                    maxSum = Math.Max(a[i], maxSum);
                    sum = 0;
                }
            }

        return maxSum;