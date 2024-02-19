package com.ceica.restcountriesfx.services;

import com.ceica.restcountriesfx.models.CountryDTO;

import java.util.List;

public interface IRestCountries {
    public String[] getRegions();
    public List<CountryDTO> getCountriesByRegion(String region);
    public CountryDTO getCountriesByName(String name);
}
