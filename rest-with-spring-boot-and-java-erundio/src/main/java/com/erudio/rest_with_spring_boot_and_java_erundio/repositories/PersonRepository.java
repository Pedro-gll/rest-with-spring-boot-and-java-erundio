package com.erudio.rest_with_spring_boot_and_java_erundio.repositories;

import com.erudio.rest_with_spring_boot_and_java_erundio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
