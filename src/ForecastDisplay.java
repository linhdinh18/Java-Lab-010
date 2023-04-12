/**
 * @author Trevor Hartman
 * @author Linh Dinh
 *
 * @since version 1.0
 */
public class ForecastDisplay implements Display{
    private WeatherStation weatherStation;
    private float lastPressure;
    private float currentPressure;
    public ForecastDisplay(WeatherStation ws) {
        this.weatherStation = ws;
        this.weatherStation.registerDisplay(this);
        lastPressure = weatherStation.getPressure();
    }

    @Override
    public void update(){
        this.currentPressure = this.weatherStation.getPressure();
        display();

    }
    @Override
    public void display(){
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
