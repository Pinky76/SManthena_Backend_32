package com.example.CrudAPISpringAPICalling.Controller;
import lombok.Data;

@Data
public class UserDetails {
    private String id;
    private String consultantName;
    private String submissionDate;
    private String leadName;
    private String vendorName;
    private String salesPerson;
    private double rate;
    private String technology;

    public UserDetails(String consultantName, String submissionDate, String leadName, String vendorName, String salesPerson, double rate,String technology) {
        this.consultantName = consultantName;
        this.submissionDate = submissionDate;
        this.leadName = leadName;
        this.vendorName = vendorName;
        this.salesPerson = salesPerson;
        this.rate = rate;
        this.technology = technology;
    }
}
