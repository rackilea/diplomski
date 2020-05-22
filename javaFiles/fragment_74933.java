PackageSummarySupplier model = ViewModelProviders.of(this).get(PackageSummarySupplier.class);
    model.getPackageSummaryList().observe(this, packageSummaryList -> {
        adapter = new AdapterApplist(context, packageSummaryList);

        recyclerView.setAdapter(adapter);
    });