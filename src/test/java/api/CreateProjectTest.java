package api;

import io.restassured.http.ContentType;
import model.api.requests.ProjectRequest;
import model.api.responses.ProjectResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class CreateProjectTest {
    @Test
    public void createProjectTest() {
        String projectCode = generateProjectCode();
        File file = new File("code.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(projectCode.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Expected code is:" +projectCode);
        ProjectRequest projectRequest = ProjectRequest.builder().title("some new title").code(projectCode).
                build();

        ProjectResponse projectResponse = given().baseUri("https://api.qase.io/v1/").
                header("Token","cb32d9e2a156ddf83660dc641dc8074fd5aa247e").
                header("Content-Type", ContentType.JSON).
        when().
                body(projectRequest).
                post("project").
        then().
                log().all().
                statusCode(200).
                extract().body().as(ProjectResponse.class);
        System.out.println("Actual code is:" +projectResponse.getResult().getCode());


    }
    private static String generateProjectCode() {
        return RandomStringUtils.randomAlphabetic(2, 5).toUpperCase();
    }
}
