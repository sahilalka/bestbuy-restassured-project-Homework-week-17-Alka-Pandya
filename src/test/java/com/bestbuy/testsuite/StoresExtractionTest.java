package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    // 1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String nameOfStore = response.extract().path("data[4].name");
        System.out.println("The name of 5th store is :" + nameOfStore);
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> namesOfAllStores = response.extract().path("Stores");
        System.out.println(namesOfAllStores);

    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println("List of Ids are : " + storeId);
    }

    // 6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> storeId = response.extract().path("data.id");
        int num = storeId.size();
        System.out.println("Size of the Product is " + num);
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> valueOfStore = response.extract().path("data.findAll{it.name == 'St Cloud'");
        System.out.println("All the value of the store where store name = St Cloud :" + valueOfStore);
    }

    // 8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String>addressOfStore = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("The address of the store where store name = Rochester is : " + addressOfStore);
    }
    //9. Get all the services of 8th store
    @Test
    public void test009() {
        String services = response.extract().path("data[7].store");
        System.out.println("The services of 8th store is :" + services);
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<HashMap<String, ?>> windowsStoreServices = response.extract().path("data.findAll { it.services.find { it.name == 'Windows Store' } != null }.services.storeservices");
        System.out.println("Storeservices of the store where service name = Windows Store is " + windowsStoreServices);
    }

    //11.Get all the storeId of all the store
    @Test
    public void test0011() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("The storeId of all the store :" + storeId);
}
   //12. Get id of all the store
    @Test
    public void test012(){
        List<Integer> Id = response.extract().path("data.id");
        System.out.println("List of Ids are : " + Id);

    }
    //13. Find the store names Where state = ND
    @Test
    public void test013(){
        List<String> name = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("Store names Where state = ND " + name );
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
        List<List<?>> services = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        int number = services.size();
        System.out.println("Total number of services : " + number);
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll { it.services.find { it.name == 'Windows Store' } != null }.services.createdAt");
        System.out.println("The createdAt for all services whose name = “Windows Store” :"  + createdAt );
    }
    //16.Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<HashMap<String, ?>> name = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println("The name of all services Where store name = “Fargo” : "  + name);
    }
    //17.Find the zip of all the store
    @Test
    public void test017(){
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("The  zip of all the store :" + zip);
    }
    //18.Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("The zip of store name = Roseville : " + zip);
    }
    //19.Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<HashMap<String,?>> storeservicesDetail = response.extract().path("data.findAll { it.services.find { it.name == 'Magnolia Home Theater' } != null }.services.storeservices");
        System.out.println("The storeservices details of the service name = Magnolia Home Theater : " + storeservicesDetail);
    }
    // 20.Find the lat of all the stores
    @Test
    public void test020(){
        List<String> lat = response.extract().path("data.lat");
        System.out.println("The  lat of all the store :" + lat);
    }

    }


















