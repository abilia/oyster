package com.abilia.oyster.services

import com.abilia.oyster.models.BusinessCard
import com.abilia.oyster.models.Company
import com.abilia.oyster.models.Occupation
import com.abilia.oyster.repositories.CompanyRepository
import com.abilia.oyster.repositories.OccupationRepository
import com.abilia.oyster.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
open class BusinessCardService(private val personRepository: PersonRepository, private val companyRepository: CompanyRepository, private val occupationRepository: OccupationRepository) {

    fun getBusinessCards(city: String): List<BusinessCard> {
        val companies = companyRepository.getCompaniesFromCity(city)
        val businessCards = arrayListOf<BusinessCard>()
        for (company: Company in companies) {
            val occupations = occupationRepository.getOccupationsFromCompanyId(company.id)
            for (occupation: Occupation in occupations) {
                val person = personRepository.getPerson(occupation.person_id)
                businessCards.add(BusinessCard(person.id, person.fullName, occupation.occupation, company.name))
            }

        }


        return businessCards
    }
}