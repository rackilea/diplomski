doAnswer(invocation -> {
            Mother toSave = (Mother) invocation.getArgument(0);
            ReflectionTestUtils.setField(toSave, "id", expectedId);

            for (int k = 0; k < toSave.getKids().size(); k++) {
                ReflectionTestUtils.setField(toSave.getKids().get(k), "id", expectedId + k + 1);
            }

            return null;
        }).when(dao).save(entity);