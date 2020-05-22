table.debug();
            table.add(heading).colspan(3).expandX().spaceBottom(50).row();;
            table.add(scrollPane).uniformX().expandY().top().left();
            table.add(window).padLeft(30);
            // table.add(play).uniformX();
            table.add(back).uniformX().bottom().right().padLeft(550);
            stage.addActor(table);