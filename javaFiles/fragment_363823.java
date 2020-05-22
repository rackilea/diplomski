<select id="identifyPaymentCapabilities" parameterType="PaymentCapabilities" statementType="CALLABLE">
    DECLARE
        v_payment_capabilities APS.Payment_Capabilities;
    BEGIN
        v_payment_capabilities := APS.get_payment_capabilities(#{customerId, javaType=Integer, jdbcType=NUMERIC, mode=IN});

        #{partialPaymentPP, javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.pp_partial_payment;
        #{advancePaymentCO, javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.co_advance_payment;
        #{depositPaymentDP, javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.dp_deposit_payment;
        #{depositRepayDR,   javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.dr_deposit_repay;
        #{walletPaymentWP,  javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.wp_wallet_payment;
        #{walletRepayWR,    javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.wr_wallet_repay;
        #{prepaidPaymentSS, javaType=Integer, jdbcType=NUMERIC, mode=OUT} := v_payment_capabilities.ss_prepaid_payment;
    END;
</select>