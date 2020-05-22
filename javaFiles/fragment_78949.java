while(st.hasMoreTokens()) {

                    w = new Weapon(WeaponCategory.fromString(st.nextToken()),
                            st.nextToken(),st.nextToken(),st.nextToken(),
                            st.nextToken(),st.nextToken(),st.nextToken(),
                            st.nextToken(),st.nextToken());
                    weapons.put(w.getName(), w);
                }