package com.renault.entities;

import jdk.jfr.Enabled;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 16, nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @NotNull
    @Length(min = 2)
    @Column(length = 512, nullable = false)
    private String name;

    @OneToMany( mappedBy = "country",
                fetch = FetchType.EAGER,
                cascade = CascadeType.REMOVE)
    private List<Region> regions;

    public Country() {
    }

    public Country(Language language, String name) {
        this.language = language;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", language=" + language +
                ", name='" + name + '\'' +
                '}';
    }

}
