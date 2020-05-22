public void shows_xxx_index_view {
    assertThat(modelAndView.getViewName(), equalTo("controller/index"));
}

public void model_contains_search_results {
    assertThat(modelAndView.getModelMap().get("searchResults"), equalTo(expected_results));
}