package org.webapp.webAppBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.webAppBoot.models.person;

@Repository
public interface peopleRepository extends JpaRepository<person, Integer> {

}
