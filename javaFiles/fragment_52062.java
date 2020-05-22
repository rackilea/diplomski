void Generate(int[] source, List<int[]> result, int[] build, int k, int num) {
      if (num == k) {
        int[] a = (int[])build.clone();
        result.add(a);
        return;
      }

      for (int i = 0; i < source.length; i++)
        if (num == 0 || source[i] != build[num - 1])
        {
          build[num] = source[i];
          Generate(source, result, build, k, num + 1);
        }
    }