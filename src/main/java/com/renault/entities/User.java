package com.renault.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 512, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "user_city",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "city_id"))
    private List<City> followedCities;

    public User() {
        //
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getFollowedCities() {
        return followedCities;
    }

    public void setFollowedCities(List<City> followedCities) {
        this.followedCities = followedCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
