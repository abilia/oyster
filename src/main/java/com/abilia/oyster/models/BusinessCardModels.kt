package com.abilia.oyster.models

data class Person(val id: Int, val fullName: String)
data class Company(val id: Int, val name: String, val city: String)
data class Occupation(val person_id: Int, val company_id: Int, val occupation: String)
data class BusinessCard(val id: Int, val name: String, val occupation: String, val company: String)
