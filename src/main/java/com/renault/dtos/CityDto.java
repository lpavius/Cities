package com.renault.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CityDto {

    private int id;

    @NotNull
    @Length(min = 2)
    private String name;

    public CityDto() {
        //
    }

    public CityDto(int id, String name) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
