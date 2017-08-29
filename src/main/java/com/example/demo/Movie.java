package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String title;

    @Min(1900)
    private long year;

    @NotEmpty
    private String description;

    @ManyToMany
    @JoinTable(name = "movie_actor",
               joinColumns = @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID"),
               inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ID"))
    private Set<Actor> cast;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


