table.debug();

                table.add(heading).colspan(3).expandX().spaceBottom(50).row();
                table.add(scrollPane).uniformX().expandY().top().left();
                table.add(window).top();
                // table.add(play).uniformX();
                table.add(back).uniformX().bottom().right();

                stage.addActor(table);