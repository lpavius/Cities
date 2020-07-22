package com.renault.dtos;

import com.renault.entities.Country;

public class CountryRegionDto {

    private CountryDto country;

    private RegionDto region;

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "CountryRegionDto{" +
                "country=" + country +
                ", region=" + region +
                '}';
    }
}
