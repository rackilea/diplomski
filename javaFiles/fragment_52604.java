bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_explorer:
                                    return true;

                                case R.id.action_ready:
                                    return true;

                                case R.id.action_account:
                                    fragmentTransaction.replace(R.id.content , new Account());
                                    fragmentTransaction.commit();
                                    return true;

                            }
                            return true;
                        }
                    });