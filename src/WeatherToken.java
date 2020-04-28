public class WeatherToken {
    private String city;
    private double temperature;
    private double humidity;
    private String clouds;
    private double windSpeed;
    private String out;

    public void setData(String city, double temp, double hum, String cl, double wind)
    {
        temperature = temp;
        humidity = hum;
        clouds = cl;
        windSpeed = wind;
        out = "Положение в городе *" + city + ":\nТемпература:* " + temperature + " °С\n*Состояние:* " + clouds + "\n*Скорость ветра:* " + windSpeed + "\n*Влажность:* " + humidity;
    }

    public String getData()
    {
        return out;
    }

}
