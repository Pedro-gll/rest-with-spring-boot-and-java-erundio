package com.erudio.rest_with_spring_boot_and_java_erundio.services;

import com.erudio.rest_with_spring_boot_and_java_erundio.data.vo.v1.PersonVO;
import com.erudio.rest_with_spring_boot_and_java_erundio.data.vo.v2.v1.PersonVOV2;
import com.erudio.rest_with_spring_boot_and_java_erundio.exception.ResourceNotFoundException;
import com.erudio.rest_with_spring_boot_and_java_erundio.mapper.ModelMapper;
import com.erudio.rest_with_spring_boot_and_java_erundio.mapper.custom.PersonMapper;
import com.erudio.rest_with_spring_boot_and_java_erundio.model.Person;
import com.erudio.rest_with_spring_boot_and_java_erundio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper mapper;

    public List<PersonVO> findAll(){
        logger.info("Find all persons");

        return ModelMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person");

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        return ModelMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){

        logger.info("Creating new person");

        var entity = ModelMapper.parseObject(person, Person.class);

        var vo = ModelMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person){

        logger.info("Creating new person");
        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVO(personRepository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating person");

        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = ModelMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting person");

        personRepository.deleteById(id);
    }

}
