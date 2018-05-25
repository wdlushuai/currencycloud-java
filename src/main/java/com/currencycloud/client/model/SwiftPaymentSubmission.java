package com.currencycloud.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import net.minidev.json.JSONObject;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwiftPaymentSubmission {
    private String mt103;
    private String status;
    private String submissionRef;

    protected SwiftPaymentSubmission() {
    }

    public SwiftPaymentSubmission(String mt103, String status, String submissionRef) {
        this.mt103 = mt103;
        this.status = status;
        this.submissionRef = submissionRef;
    }

    public String getMt103() {
        return mt103;
    }

    public void setMt103(String mt103) {
        this.mt103 = mt103;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmissionRef() {
        return submissionRef;
    }

    public void setSubmissionRef(String submissionRef) {
        this.submissionRef = submissionRef;
    }

    @Override
    public String toString() {
        return new JSONObject()
                .appendField("mt103", mt103)
                .appendField("status", status)
                .appendField("submissionRef", submissionRef)
                .toString();
    }
}
