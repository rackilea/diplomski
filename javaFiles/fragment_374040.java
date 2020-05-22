package io.woolford.entity;

import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;
import java.util.Date;

public class PermitRecord {

    @Trim
    @Parsed(field = "strap")
    private String strap;

    @Parsed(field = "issued_by")
    private String issuedBy;

    @Parsed(field = "permit_num")
    private String permitNum;

    @Parsed(field = "permit_category")
    private String permitCategory;

    @Format(formats = {"MM/dd/yyyy"})
    @Parsed(field = "issue_dt")
    private Date issueDt;

    @Parsed(field = "estimated_value")
    private Integer estimatedValue;

    @Parsed(field = "description")
    private String description;

    // getters & setters removed for brevity
}