Arrays.sort(customer, new Comparator<String[]>() {
                  @Override
                  public int compare(final String[] first, final String[] second) {
                    final Integer temp1 = Integer.valueOf(first[1]);
                    final Integer temp2 = Integer.valueOf(second[1]);
                    return temp1.compareTo(temp2);
                  }
                });