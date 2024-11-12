package com.erudio.rest_with_spring_boot_and_java_erundio.mapper.custom;

import com.erudio.rest_with_spring_boot_and_java_erundio.data.vo.v2.v1.PersonVOV2;
import com.erudio.rest_with_spring_boot_and_java_erundio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setBirthDate(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        //vo.setBirthDate(new Date());
        return entity;
    }
}
