package com.abilia.oyster.controllers;

import com.abilia.oyster.models.BusinessCard;
import com.abilia.oyster.services.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BusinessCardController {

    @Autowired
    private BusinessCardService businessCardService;

    @RequestMapping("/businesscards")
    public List<BusinessCard> businessCard(@RequestParam(value = "city", defaultValue="Gothenburg") String city) {
        List<BusinessCard> businessCards = businessCardService.getBusinessCards(city);
        return businessCards;
    }
}
