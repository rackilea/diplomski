if (c2 == c1) {
        if (c1 != c3) {
          c3 += c1;
          System.out.println(c3);
          c3 *= c2;
        } else {
          c3 += c1;
          System.out.println(c3);
          c3 *= c1;
          if (c1 < c2)
            c2 += 7;
          else
            c2 += 5;
        }
      } else if (c1 < c2)
          c2 += 7;
        else
          c2 += 5;
    }
    System.out.println(c1 + c2 + c3);
  }
}