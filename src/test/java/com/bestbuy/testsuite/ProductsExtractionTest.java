package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }

    //21. Extract the limit
    @Test
    public void test021() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
    }

    //22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);
    }

    //23. Extract the name of 5th product
    @Test
    public void test023() {
        String productName5 = response.extract().path("data[4].name");
        System.out.println("The name of 5th product is : " + productName5);

    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        List<String> namesOfAllProducts = response.extract().path("data");
        System.out.println(namesOfAllProducts);
    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> listOfIds = response.extract().path("data.id");
        System.out.println("List of Ids are : " + listOfIds);
    }

    //26. Print the size of the data list
    @Test
    public void test026() {
        List<Integer> ids = response.extract().path("data");
        int num = ids.size();
        System.out.println("The size of the data list : " + num);
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027() {
        List<HashMap<String, ?>> valueOfProduct = response.extract().path("data.findAll{it.name == ' Energizer - MAX Batteries AA (4-Pack)'");
        System.out.println("All the value of the product where product name is : = " + valueOfProduct);
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028() {
        List<HashMap<String, ?>> modelOfProduct = response.extract().path("data.findAll{it.name == ' Energizer - N Cell E90 Batteries (2-Pack)'");
        System.out.println("All the model of the product where product name is : = " + modelOfProduct);
    }

    //29. Get all the categories of 8th products
    @Test
    public void test029() {
        String productOf8 = response.extract().path("data[7].categories");
        System.out.println("The categories of 8th products is : " + productOf8);
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<HashMap<String, ?>> category = response.extract().path("data.findAll{it.id == 150115}.categories");
        System.out.println("The name categories of the store where product id is : " + category);
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<String> listOfDescriptions = response.extract().path("data. description");
        System.out.println("The descriptions of all the products are " + listOfDescriptions);

    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<HashMap<String, ?>> allIdOfCategories = response.extract().path("data.categories.id");
        System.out.println(allIdOfCategories);
    }


    //33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<String> productName = response.extract().path("data.findAll{it.type='HardGood'}.name");
        System.out.println(productName);
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<HashMap<String, ?>> totalCategories1 = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println(totalCategories1);
        int size = totalCategories1.size();
        System.out.println(size);
    }

    // 35.Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price<5.99}.categories.createdAt");
        System.out.println("CreatedAt (price<5.99) : " + createdAt);

    }
    // 36.Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)"
   @Test
   public void test036(){
        List<HashMap<String, ?>> categories = response.extract().path("data.findAll{it.product name == “Energizer - MAX Batteries AA (4-Pack)}.categories");
        System.out.println("The name all categories  where product name is : " + categories);
    }
    //37. Find the manufacturer of all the product
    @Test
    public void test037() {
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("manufacturer of all products : " + manufacturer);
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038(){
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.image == 'Energizer'}.manufacturer");
        System.out.println("The image of products whose manufacturer is = Energizer : "  + image);
    }
    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039() {
        List<String> createdAt = response.extract().path("data.findAll{it.price>5.99}.categories.createdAt");
        System.out.println("CreatedAt (price>5.99) : " + createdAt);
    }

    //40. Find the uri of all the products
    @Test
    public void test040() {
        List<String> url = response.extract().path("data.url");
        System.out.println("Url of all products : " + url);
    }


}