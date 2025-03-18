public class BasePlusCommissionEmployee extends CommissionEmployee {
    private float baseSalary;

    /**
     * Constructor with all fields
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param grossSales weekly sales amount
     * @param commission commission percentage
     * @param baseSalary base weekly salary
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, int id,
                                      float grossSales, int commission, float baseSalary) {
        super(firstName, lastName, id, grossSales, commission);
        setBaseSalary(baseSalary);
    }

    /**
     * Default constructor
     */
    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    /**
     * Get base salary
     * @return the base salary
     */
    public float getBaseSalary() {
        return baseSalary;
    }

    /**
     * Set base salary
     * @param baseSalary the base salary to set
     * @throws IllegalArgumentException if base salary is negative
     */
    public void setBaseSalary(float baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        this.baseSalary = baseSalary;
    }

    /**
     * Override of toString method
     * @return a string representation of the base plus commission employee
     */
    @Override
    public String toString() {
        return super.toString().replace("Weekly Earnings:", "")
                + ", Base Salary: " + String.format("%.2f", baseSalary) +
                ", Weekly Earnings: " + String.format("%.2f", earnings());
    }

    /**
     * Override of equals method
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;

        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;

        return Float.compare(baseSalary, other.baseSalary) == 0;
    }

    /**
     * Implementation of earnings method
     * @return the base plus commission employee's earnings (baseSalary + commission * grossSales / 100)
     */
    @Override
    public float earnings() {
        return baseSalary + super.earnings();
    }
}