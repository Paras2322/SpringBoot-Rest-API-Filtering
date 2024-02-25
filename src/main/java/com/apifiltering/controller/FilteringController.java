package com.apifiltering.controller;

import com.apifiltering.entities.Student;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        Student student = new Student("Paras Bagga", "Gurgaon", "8437861802");
        return applyFiltering(student, "name", "city");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<Student> list = Arrays.asList(
                new Student("Paras Bagga", "Gurgaon", "8437861802"),
                new Student("Twinkle Mahajan", "Amritsar", "9000001234"),
                new Student("Aarushi Mahajan", "Gurgaon", "9999991234")
        );
        return applyFiltering(list, "name", "mobile");
    }

    // Dynamic Filtering
    
    private MappingJacksonValue applyFiltering(Object object, String... properties) {
        MappingJacksonValue jacksonValue = new MappingJacksonValue(object);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("StudentFilter", filter);
        jacksonValue.setFilters(filters);
        return jacksonValue;
    }
}
