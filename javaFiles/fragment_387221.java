Call<SubmitSurvey> getSubmit(@Path("add") String add,
                             @Field("moderator_id") int moderator_id,
                             @Field("visitor_name") String visitor_name,
                             @Field("visitor_mobile") String visitor_mobile,
                             @Field("entity_id") int entity_id,
                             @Query ReqAnsQues visitor_gender
);