package com.maxpay.test.api;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {

    @Test
    public void shouldGetLuke(){
        String homeworld = when().get("http://swapi.co/api/people/1/")
                .then().statusCode(200)
                .and()
                .body("name", equalTo("Luke Skywalker")).extract().path("homeworld");

//        System.out.println(homeworld);

        List<String> getFilms =  get(homeworld)
                .then()
                .statusCode(200)
                .and()
                .body("name", equalTo("Tatooine")).and().body("population", equalTo("200000")).extract().path("films");


//                System.out.println(getFilms.get(0));

       ValidatableResponse verifyThatFilmRelateToLukeAndHimPlanet =  get(getFilms.get(0))
                .then().statusCode(200)
                .and()
                .body("title", equalTo("Attack of the Clones")).and().body("characters[0]", hasItem("http://swapi.co/api/people/1/")).and().body("planets[0]", hasItem(homeworld));


    }
}
