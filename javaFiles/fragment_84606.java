@Entity
@SqlResultSetMapping(name="OutcomeDetails",
        entities={
                @EntityResult(entityClass=OutcomeDetailsEntity.class, fields={
                        @FieldResult(name="REASON_CD", column="REASON_CD"),
                        @FieldResult(name="STATUS_CD", column="STATUS_CD"),
                        @FieldResult(name="COUNTERED_FLG", column="COUNTERED_FLG"),
                        @FieldResult(name="ID", column="ID"),
                        @FieldResult(name="VERSION", column="VERSION"),
                        @FieldResult(name="CREATED_D", column="CREATED_D"),
                        @FieldResult(name="MODIFIED_D", column="MODIFIED_D"),
                        @FieldResult(name="CORRELATION_ID", column="CORRELATION_ID"),
                        @FieldResult(name="POLICY_ID", column="POLICY_ID"),
                        @FieldResult(name="MODEL_ID", column="MODEL_ID"),
                        @FieldResult(name="SRC_ID", column="SRC_ID"),
                        @FieldResult(name="REF_ID", column="REF_ID"),
                        @FieldResult(name="SERVICE_NAME", column="SERVICE_NAME"),
                        @FieldResult(name="POLICY", column="POLICY"),
                        @FieldResult(name="POLICY_VERSION", column="POLICY_VERSION"),
                })
        })