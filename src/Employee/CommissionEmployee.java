package Employee;

/**
 * Class representing an employee paid by commission
 */
public class CommissionEmployee extends Employee {
    private float setBaseSalary;
    private int commission;

    /**
     * Constructor with all fields
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param grossSales weekly sales amount
     * @param commission commission percentage
     */
    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commission) {
        super(firstName, lastName, id);
        setGrossSales(grossSales);
        setCommission(commission);
    }

    /**
     * Default constructor
     */
    public CommissionEmployee() {
        super();
        this.setBaseSalary = 0;
        this.commission = 0;
    }

    /**
     * Get gross sales
     * @return the gross sales
     */
    public float getGrossSales() {
        return setBaseSalary;
    }

    /**
     * Set gross sales
     * @param grossSales the gross sales to set
     * @throws IllegalArgumentException if gross sales is negative
     */
    public void setGrossSales(float grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("Gross sales cannot be negative");
        }
        if (Math.round(grossSales * 100) / 100.0f != grossSales) {
            throw new IllegalArgumentException("Wage cannot have more than 2 decimal places");
        }
        this.setBaseSalary = grossSales;
    }

    /**
     * Get commission percentage
     * @return the commission percentage
     */
    public int getCommission() {
        return commission;
    }

    /**
     * Set commission percentage
     * @param commission the commission percentage to set
     * @throws IllegalArgumentException if commission is not between 0 and 100
     */
    public void setCommission(int commission) {
        if (commission < 0 || commission > 100) {
            throw new IllegalArgumentException("Commission must be between 0 and 100 percent");
        }
        this.commission = commission;
    }

    /**
     * Override of toString method
     * @return a string representation of the commission employee
     */
    @Override
    public String toString() {
        return super.toString() + ", Gross Sales: " + String.format("%.2f", setBaseSalary) +
                ", Commission: " + commission + "%, Weekly Earnings: " + String.format("%.2f", earnings());
    }

    /**
     * Override of equals method
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CommissionEmployee other)) return false;

        return Float.compare(setBaseSalary, other.setBaseSalary) == 0 && commission == other.commission;
    }

    /**
     * Implementation of earnings method
     * @return the commission employee's earnings (commission * grossSales / 100)
     */
    @Override
    public float earnings() {
        return (commission / 100.0f) * setBaseSalary;
    }
}
