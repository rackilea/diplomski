final Foo foo = new Foo();
bar.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            foo.doBaz();
        }
});