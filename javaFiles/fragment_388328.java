Intent intent = new Intent();
Bundle bundle = new Bundle();
bundle.putParcelable("coupon", coupon); // or putSerializable()
intent.putExtras(bundle);
intent.setClass(context, IndividualCouponActivity.class);
context.startActivity(intent);