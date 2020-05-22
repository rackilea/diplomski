limit_number = getIntExtra("limit_basic", -1 /* or other default value */);

// or, if you want to explicitly check for presence of the extra:
if (hasExtra("limit_basic")) {
    limit_number = getIntExtra("limit_basic", -1);
}