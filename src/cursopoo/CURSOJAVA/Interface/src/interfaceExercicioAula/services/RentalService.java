package interfaceExercicioAula.services;

import interfaceExercicioAula.entities.CarRental;
import interfaceExercicioAula.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private BrazilTaxService taxService;
    private Double pricePerHour;
    private Double pricePerDay;


    public RentalService(BrazilTaxService taxService, Double pricePerHour, Double pricePerDay) {
        this.taxService = taxService;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
    }

    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;

        double basicPayment;
        if (hours <= 12){
             basicPayment = pricePerHour * Math.ceil(hours);
        }
        else{
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public BrazilTaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(BrazilTaxService taxService) {
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
