ArrayList<ProductModule> daftarproductmodule = new ArrayList<ProductModule>();
        Cursor cursor = database.query(DBHelper.PRODUCT_MODULE,
                allProductModule, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ProductModule ProductModule = cursorToProductModule(cursor);
          daftarproductmodule.add(ProductModule);
          cursor.moveToNext();
        }
        cursor.close();
        return daftarproductmodule;
      }