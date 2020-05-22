case R.id.HighToLow:
          Collections.sort(subCategoryViewDataBeanArrayList, new Comparator<SubCategoryViewDataBean>() {
          @Override
          public int compare(SubCategoryViewDataBean s1, SubCategoryViewDataBean s2) {
          return Integer.parseInt(String.valueOf(s2.price)) - Integer.parseInt(String.valueOf(s1.price));
          }
        });
        BindData(subCategoryViewDataBeanArrayList);
        break;

        case R.id.LowToHigh:
                    Collections.sort(subCategoryViewDataBeanArrayList, new Comparator<SubCategoryViewDataBean>() {
                     @Override
                     public int compare(SubCategoryViewDataBean s1, SubCategoryViewDataBean s2) {
                     return Integer.parseInt(String.valueOf(s1.price)) - Integer.parseInt(String.valueOf(s2.price));

                     }
                  });
                  BindData(subCategoryViewDataBeanArrayList);