package ca.bcit.comp2522.labs.json;
/**
 *  com.json requires a maven library:
 *  File -> Project Structure -> Project Settings -> Libraries -> Add -> from Maven ->
 *    org.json:json:20201115
 *
 *  The Block Text used for the json string requires an experiemental version of Java 14
 *  IntelliJ:
 *  File -> Project Structure -> Project Settings -> Project -> Project Language Level ->
 *    14 (Preview) Records, Patterns and text blocks
 */
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo2 {

    public static void main(String[] args) {
        //String json = "{ \"name\"" +
        //        "";
        String json = """
                      { 
                        "name": "Celore", 
                        "age" : 22
                      }
                      """;

        System.out.println("age:"+new JSONObject(json).getInt("age"));
        System.out.println("name:"+new JSONObject(json).getString("name"));

        String json2 = """
                      [
                        "Mary",
                        "Bob",
                        "Joe"
                      ]
                      """;

        System.out.println("last:"+new JSONArray(json2).getString(2));
        System.out.println("first:"+new JSONArray(json2).getString(0));
        //System.out.println("error:"+new JSONArray(json2).getString(3));

        String json3 = """
                    {
                      "locations": [
                        {
                          "timestampMs": "1388528663181",
                          "latitudeE7": 49242360,
                          "longitudeE7": -123112852,
                          "accuracy": 12,
                          "point": {
                             "x" : 5,
                             "y" : 7
                          }
                        },
                        {
                          "timestampMs": "1388528679927",
                          "latitudeE7": 49243334,
                          "longitudeE7": -123113989,
                          "accuracy": 10,
                          "activity": [
                            {
                              "timestampMs": "1388528692191",
                              "activity": [
                                {
                                  "type": "STILL",
                                  "confidence": 80
                                },
                                {
                                  "type": "UNKNOWN",
                                  "confidence": 15
                                },
                                {
                                  "type": "IN_VEHICLE",
                                  "confidence": 4
                                }
                              ]
                            }
                          ]
                        }
                      ]
                    }
                    """;
        System.out.println("element:"+new JSONObject(json3).getJSONArray("locations").getJSONObject(1).getInt("latitudeE7"));
        System.out.println("test: "+new JSONObject(json3).getJSONArray("locations").getJSONObject(1).getJSONArray("activity").getJSONObject(0).getString("timestampMs"));

    }
}
