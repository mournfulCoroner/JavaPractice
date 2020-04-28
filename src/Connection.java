import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Connection {

    private final static String key = "&appid=dd010dce41e71e1523ac80c4c00a0211";
    private final static String baseURL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private final static String lang = "&lang=ru";

    private String city;

    private String urlString;

    Connection(String city)
    {
        this.city = city;
        this.urlString = baseURL + city + key + lang;
    }

    public String get()
    {
        if(getWeather(city) != null) return getWeather(city).getData();
        else return "Такой город ещё _не видел свет_ в этом мире. Не торопись, мой мальчик.";
    }

    public WeatherToken getWeather(String city){
        WeatherToken w = null;

        try {

            URL openWeather = new URL(urlString);
            URLConnection urlConnection = openWeather.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            String jsonLine = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonLine += inputLine;
            in.close();

            JSONObject jsonObject = new JSONObject(jsonLine);

            JSONArray list = (JSONArray) jsonObject.get("list");


            JSONObject item = (JSONObject) list.get(0);

            JSONObject main = (JSONObject) item.get("main");
            JSONArray weatherJSONArray = (JSONArray) item.get("weather");
            JSONObject clouds = weatherJSONArray.getJSONObject(0);
            JSONObject wind = (JSONObject) item.get("wind");

            w = new WeatherToken();
            w.setData(city, Math.round(main.getDouble("temp")-270), Math.round(main.getDouble("humidity")),
                    clouds.getString("description"), Math.round(wind.getDouble("speed")));

        } catch (IOException | JSONException e) {
            //e.printStackTrace();
            return null;
        }
        return w;
    }
}
