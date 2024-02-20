package com.ceica.restcountriesfx.services;

import com.ceica.restcountriesfx.models.CountryDTO;

import java.util.ArrayList;
import java.util.List;

public class FakeRestCountriesService implements IRestCountries {

    @Override
    public String[] getRegions() {
        return new String[]{"EuropaFake", "AsiaFake", "AfricaFake", "AmericaFake", "OceaniaFake"};
    }

    @Override
    public List<CountryDTO> getCountriesByRegion(String region) {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName("SpainFake");
        countryDTOList.add(countryDTO);

        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setName("FranceFake");
        countryDTOList.add(countryDTO1);

        CountryDTO countryDTO2 = new CountryDTO();
        countryDTO2.setName("ChinaFake");
        countryDTOList.add(countryDTO2);

        CountryDTO countryDTO3 = new CountryDTO();
        countryDTO3.setName("CanadaFake");
        countryDTOList.add(countryDTO3);

        CountryDTO countryDTO4 = new CountryDTO();
        countryDTO4.setName("BrazilFake");
        countryDTOList.add(countryDTO4);

        CountryDTO countryDTO5 = new CountryDTO();
        countryDTO5.setName("JapanFake");
        countryDTOList.add(countryDTO5);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountriesByName(String name) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName("Spain");
        countryDTO.setRegion("Europa");
        countryDTO.setCapital("Madrid");
        countryDTO.setCoin("Euro");
        countryDTO.setFlag("https://flagcdn.com/w320/es.png");
        countryDTO.setPopulation(38000000);
        return countryDTO;
    }
}
