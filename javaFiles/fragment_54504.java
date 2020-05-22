@Test
    public void testReturnWidgetIdsFromSearchWord(){
        List<Integer> widgetIds = null;
        String searchText = "someText";

        /*when(jdbt.queryForList("SELECT idwidgets FROM descriptions "
                + "WHERE descriptiontext LIKE '%"+ searchText + "%'", 
                args, Integer.class)).thenReturn(idList);*/

        when(jdbt.queryForList(Matchers.anyString(), Matchers.any(MapSqlParameterSource.class), 
                (Class<Integer>) Matchers.anyVararg())).thenReturn(idList);

        widgetIds = (List<Integer>) dDao.returnWidgetIdsFromSearchWord(searchText);

        System.out.println(widgetIds.size());

        assertEquals(widgetIds, idList);
    }