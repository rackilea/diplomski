@Test
@Transactional
public void createNewWorkWorkWhenCreatedJobItemAndQuantitiesPoolShouldBeCreated() throws Exception {

    mockMvc.perform(post("/api/tracker/jobs/work")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(workRequest)))
        .andExpect(status().isCreated())
        .andDo(mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            workRequestResponse = (WorkRequestResponse) TestUtil.convertJSONStringToObject(json, WorkRequestResponse.class);
        });

    Work work = workService.findWorkById(workRequestResponse.getWorkId());

    assertThat(work.getJobItem().getJobItemName()).isEqualTo(workRequest.getJobItem().getJobItemName());
    assertThat(work.getJobItem().getQuantities()).hasSize(workRequest.getQuantities().size());
    assertThat(work.getJobItem().getQuantityPools()).hasSize(workRequest.getQuantities().size());
}