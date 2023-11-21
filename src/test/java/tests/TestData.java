package tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName(),
            company = faker.options().option("CiV Life", "Renaissance Capital", "JAMILCO",
                    "Hoff", "MODIS", "DARKSIDE", "LaModa"),
            email = faker.internet().emailAddress(),
            topics = faker.options().option("Question", "Offer", "Review");
}
