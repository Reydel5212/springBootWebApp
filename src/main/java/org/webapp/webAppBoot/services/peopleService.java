package org.webapp.webAppBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.webAppBoot.models.person;
import org.webapp.webAppBoot.repositories.peopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class peopleService {
    private final peopleRepository peopleRepository;

    @Autowired
    public peopleService(peopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<person> findAll(){
        return peopleRepository.findAll();
    }

    public person findOne(int id){
        Optional<person> foundPerson = peopleRepository.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(person person){
        person.setCreate_date(new Date());

        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
