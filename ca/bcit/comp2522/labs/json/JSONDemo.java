package ca.bcit.comp2522.labs.json;

/**
 *  com.google.gson.Gson requires a maven library:
 *  File -> Project Structure -> Project Settings -> Libraries -> Add -> from Maven ->
 *    com.google.code.gson:gson:2.8.6
 *
 *  The Block Text used for the json string requires an experiemental version of Java 14
 *  IntelliJ:
 *  File -> Project Structure -> Project Settings -> Project -> Project Language Level ->
 *    14 (Preview) Records, Patterns and text blocks
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class JSONDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Point p1 = new Point(11, -3, -1);
        Point p2 = new Point(44, -24, 0);

        String json1 = gson.toJson(p1);
        System.out.println("P1 in JSON form: "+json1);

        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        String json2 = gson.toJson(points);
        System.out.println("Points List to JSON: "+json2);

        try {
            Files.write(Paths.get("savedData.txt"), json2.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (IOException ioe) {
            System.out.println("Error writing to file");
            System.out.println(ioe);
        }



        //String json = "{\"x\": 5, \"y\": \"7\"}";
        String jsonSource = """
                          { 
                            "x":5, 
                            "y":7
                          }
                      """;
        Point point1 = gson.fromJson(jsonSource,Point.class);
        System.out.println("Point 1 from JSON: "+point1);


        String jsonSource2 = """
                      [
                          { 
                            "x":5, 
                            "y":7
                          },
                          { 
                            "x":3, 
                            "y":-1
                          }
                      ]
                      """;
        ArrayList<Point> points2 = new ArrayList<>(gson.fromJson(jsonSource2,new TypeToken<List<Point>>(){}.getType()));
        System.out.println("Points from JSON: "+points2);



        String JSONFromFile = "";
        try {
            JSONFromFile = Files.readString(Paths.get("savedData.txt"));
        }
        catch (IOException ioe) {
            System.out.println("Error reading from file");
            System.out.println(ioe);
        }

        //ArrayList<Point> pointsFromFile = new ArrayList<>(gson.fromJson(JSONFromFile,new TypeToken<List<Point>>(){}.getType()));
        //System.out.println("Points from JSON File: "+pointsFromFile);

    }
}
