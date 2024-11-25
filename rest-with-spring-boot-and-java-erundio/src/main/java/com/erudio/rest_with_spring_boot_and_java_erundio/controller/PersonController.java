package com.erudio.rest_with_spring_boot_and_java_erundio.controller;

import com.erudio.rest_with_spring_boot_and_java_erundio.data.vo.v1.PersonVO;
import com.erudio.rest_with_spring_boot_and_java_erundio.data.vo.v2.v1.PersonVOV2;
import com.erudio.rest_with_spring_boot_and_java_erundio.services.PersonServices;
import com.erudio.rest_with_spring_boot_and_java_erundio.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON,
                            MediaType.APPLICATION_XML,
                            MediaType.APPLICATION_YML})
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON,
                                                MediaType.APPLICATION_XML,
                                                MediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable(value = "id")Long id){
        return service.findById(id);
    }

    @PostMapping (
    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML},
    produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    public PersonVO create(@RequestBody PersonVO person){
        return service.create(person);
    }

    @PostMapping (
            value = "/v2",
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
        return service.createV2(person);
    }

    @PutMapping(
    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML},
    produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO person){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
