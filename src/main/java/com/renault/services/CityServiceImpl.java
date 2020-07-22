package com.renault.services;

import com.renault.entities.City;
import com.renault.entities.Country;
import com.renault.entities.Region;
import com.renault.entities.User;
import com.renault.repositories.CityRepository;
import com.renault.repositories.CountryRepository;
import com.renault.repositories.RegionRepository;
import com.renault.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserService userService;

    @Override
    public Optional<City> getCity(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void save(Country country, Region region, City city) {
        countryRepository.save(country);
        regionRepository.save(region);
        cityRepository.save(city);
    }

    @Override
    @Transactional
    public void deleteCity(City city) {
        //for (User user: city.getFollowByUser()) {
        //    userService.unfollowCityAndSave(user, city);
        //}
        city.getFollowByUser().forEach(user ->
                userService.unfollowCityAndSave(user, city)
        );
        cityRepository.delete(city);
    }
}
