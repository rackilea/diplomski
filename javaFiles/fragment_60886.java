Button butObscurity = new Button(
                        "Edit", new ClickHandler() {
                            public void onClick(ClickEvent event) {
                                 butYes = new Button(
                                        "YES", new ClickHandler() {
                                            public void onClick(ClickEvent event) {
                                                statusObscurity.setHTML("YES");
                                                hp1.remove(butYes);
                                            }
                                        });
                                butNo = new Button(
                                        "YES", new ClickHandler() {
                                            public void onClick(ClickEvent event) {
                                                statusObscurity.setHTML("NO");
                                                hp1.remove(butNo);
                                            }
                                        });
                                hp1.add(butYes);
                                hp1.add(butNo);                     
                            }
                        }
                        );