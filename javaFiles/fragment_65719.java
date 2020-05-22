/* Slower but safer algorithm due to Moler and Morrison.  Never
         produces any intermediate result greater than roughly the
         larger of X and Y.  Should converge to machine-precision
         accuracy in 3 iterations.  */

      double r = ratio*ratio, t, s, p = abig, q = asmall;

      do {
        t = 4. + r;
        if (t == 4.)
          break;
        s = r / t;
        p += 2. * s * p;
        q *= s;
        r = (q / p) * (q / p);
      } while (1);