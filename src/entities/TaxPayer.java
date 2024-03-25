package entities;

public class TaxPayer {

    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {

        if (getSalaryIncome() / 12  < 3000.0) {
            return this.salaryIncome += 0.0;
        } else if (getSalaryIncome() / 12 > 3000.0 && getSalaryIncome() / 12 < 5000.00) {
            return this.salaryIncome =  (getSalaryIncome() * 10) / 100.0;
        } else {
            return this.salaryIncome = (getSalaryIncome() * 20.0) / 100.0;
        }
    }

    public double servicesTax() {
        if (getServicesIncome() > 0.0) {
            return this.servicesIncome = (getServicesIncome() * 15.0) / 100.0;
        } else {
            return this.servicesIncome = 0.0;
        }
    }

    public double capitalTax(){
        if (getCapitalIncome() > 0.0){
            return this.capitalIncome =  (getCapitalIncome() * 20.0) / 100;
        } else {
            return this.capitalIncome = 0.0;
        }
    }

    public double grossTax(){
        return getSalaryIncome() + getServicesIncome() + getCapitalIncome();
    }

    public double taxRebate(){
        if (grossTax() > getHealthSpending() + getEducationSpending()){
            return getHealthSpending() + getEducationSpending();
        } else {
            return grossTax() * 30.0 /100.0;
        }
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }


}
