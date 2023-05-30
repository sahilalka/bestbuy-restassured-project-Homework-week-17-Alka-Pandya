package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsCRUDTest extends TestBase {
    static String name = "Duracell - AAA Batteries (4-Pack)" + TestUtils.getRandomValue();
    static String type = "HarGood" + TestUtils.getRandomValue();
    static Double price = 5.49;
    static String upc = "041333424019";
    static Double shipping = 0.0;
    static String description = "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack";
    static String manufacturer = "Duracell";
    static String model = "MN2400B4Z";
     static String url = "http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC";

     static String image = "http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg";

    @Test
    public void test001() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setUpc(upc);
        productPojo.setShipping(shipping);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        Response response = given()
                .header("Content-Type","application/jason")
                .body(productPojo)
                .when()
                .post("http://localhost:3030/products");
        response.then().log().all().statusCode(201);

    }
    @Test
    public void test002() {
        Response response = given()
                .when()
                .get("http://localhost:3030/products/9999680");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test003() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(8.88);
        productPojo.setUpc(upc);
        productPojo.setShipping(shipping);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(productPojo)
                .patch("http://localhost:3030/products/9999680");
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

    @Test
    public void test004() {
        Response response = given()
                .when()
                .delete("http://localhost:3030/products/9999680");
        response.prettyPrint();
        response.then().log().all().statusCode(200);



    }


}