FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference ref = rootRef.collection("gdgsghs.cok").document("Shsheg");
Map<String, Object> availableProducts = new HashMap<>();
Map<String, Object> zeroMap = new HashMap<>();
Map<String, Object> product = new HashMap<>();
product.put("spPrice", 63.121);
zeroMap.put("0", product);
availableProducts.put("availableProducts", zeroMap);
ref.set(availableProducts, SetOptions.merge());