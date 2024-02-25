package com.apifiltering.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"city","mobile"}) // Static Filtering
@JsonFilter("StudentFilter")
public class Student {

    private String name;
    private String city;

//    @JsonIgnore  // Static Filtering
    private String mobile;
}
