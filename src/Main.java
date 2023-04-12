/**
 * @author Trevor Hartman
 * @author Linh Dinh
 *
 * @since version 1.0
 */
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditions currentConditions = new CurrentConditions(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);
        try {
            weatherStation.measure();
        } catch (IOException e) {
            System.out.println("Failed to fetch weather data");
        }

    }
    }
