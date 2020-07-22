package com.renault.services;

import com.renault.entities.City;
import com.renault.entities.User;
import com.renault.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void followCityAndSave(User user, City city) {
        List<City> followedCities = user.getFollowedCities();
        followedCities.add(city);
        userRepository.save(user);

    }

    @Override
    public void unfollowCityAndSave(User user, City city) {
        // enlever la ville de la liste de ville dans user.cities
        //List<City> followedCities = user.getFollowedCities();
        //List<City> cities = new ArrayList<>();
        //for (City followedCity : followedCities) {
        //    if (followedCity.getId() != city.getId()) {
        //        cities.add(followedCity);
        //    }
        //}
        List<City> followedCities = user.getFollowedCities();
        List<City> cities = followedCities.stream()
                .filter(followCity -> followCity.getId() != city.getId())
                .collect(Collectors.toList());

        user.setFollowedCities(cities);
        // methode 2
        //user.getFollowedCities().removeIf(city -> city.getId() == city.getId());
        userRepository.save(user);
    }
}
