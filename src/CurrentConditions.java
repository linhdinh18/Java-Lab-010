/**
 * @author Trevor Hartman
 * @author Linh Dinh
 *
 * @since version 1.0
 */
public class CurrentConditions implements Display{
    private WeatherStation weatherStation;
    private float temperature;
    private float humidity;
    public float pressure;
    public CurrentConditions(WeatherStation ws){
        this.weatherStation = ws;
        this.weatherStation.registerDisplay(this);
    }
    @Override
    public void update(){
        this.temperature = this.weatherStation.getTemperature();
        this.humidity = this.weatherStation.getHumidity();
        this.pressure = this.weatherStation.getPressure();
        display();
    }
    @Override
    public void display(){
        System.out.printf("Current conditions: %.2f F, %.2f humidity, %.2f inHg pressure%n",
                temperature, humidity, pressure);
    }
}
