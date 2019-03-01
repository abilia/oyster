package com.abilia.oyster.services

import com.abilia.oyster.models.Person
import com.abilia.oyster.repositories.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
open class GreetingService(private val personRepository: PersonRepository) {

    fun getGreetingPerson(): Person {
        val persons = personRepository.getAllPersons()
        val randomPerson = persons.get(Random().nextInt(persons.size))
        return randomPerson
    }
}