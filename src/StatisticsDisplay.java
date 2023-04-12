/**
 * @author Trevor Hartman
 * @author Linh Dinh
 *
 * @since version 1.0
 */
public class StatisticsDisplay implements Display{
    private WeatherStation weatherStation;
    private float temperatureMin;
    private float temperatureMax;
    private float tempRunningTotal;
    private int numReadings;
    public StatisticsDisplay(WeatherStation ws){
        this.weatherStation = ws;
        this.weatherStation.registerDisplay(this);
    }

    @Override
    public void update(){
        float temperature = this.weatherStation.getTemperature();
        if (numReadings == 0) {
            temperatureMin = temperatureMax = temperature;
        } else {
            if (temperature < temperatureMin) {
                temperatureMin = temperature;
            } else if (temperature > temperatureMax) {
                temperatureMax = temperature;
            }
        }
        tempRunningTotal += temperature;
        numReadings++;
        display();

    }
    @Override
    public void display(){
        System.out.printf("Temperature: Min=%.2f F, Max=%.2f F, Avg=%.2f F%n",
                temperatureMin, temperatureMax, tempRunningTotal/numReadings);

    }

}
