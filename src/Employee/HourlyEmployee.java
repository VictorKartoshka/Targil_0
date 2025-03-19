package Employee;

/**
 * Class representing an employee paid by hour
 */

public class HourlyEmployee extends Employee {
    private int hours;
    private float wage;

    /**
     * Constructor with all fields
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID
     * @param hours weekly work hours
     * @param wage hourly wage
     */
    public HourlyEmployee(String firstName, String lastName, int id, int hours, float wage) {
        super(firstName, lastName, id);
        setHours(hours);
        setWage(wage);
    }

    /**
     * Default constructor
     */
    public HourlyEmployee() {
        super();
        this.hours = 0;
        this.wage = 0;
    }

    /**
     * Get weekly work hours
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Set weekly work hours
     * @param hours the hours to set
     * @throws IllegalArgumentException if hours is negative
     */
    public void setHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.hours = hours;
    }

    /**
     * Get hourly wage
     * @return the wage
     */
    public float getWage() {
        return wage;
    }

    /**
     * Set hourly wage
     * @param wage the wage to set
     * @throws IllegalArgumentException if wage is negative
     */
    public void setWage(float wage) {
        if (wage < 0) {
            throw new IllegalArgumentException("Wage cannot be negative");
        }
        if (Math.round(wage * 100) / 100.0f != wage) {
            throw new IllegalArgumentException("Wage cannot have more than 2 decimal places");
        }
        this.wage = wage;
    }

    /**
     * Override of toString method
     * @return a string representation of the hourly employee
     */
    @Override
    public String toString() {
        return super.toString() + ", Hours: " + hours + ", Wage: " + String.format("%.2f", wage) +
                ", Weekly Earnings: " + String.format("%.2f", earnings());
    }

    /**
     * Override of equals method
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HourlyEmployee other)) return false;

        return hours == other.hours && Float.compare(wage, other.wage) == 0;
    }

    /**
     * Implementation of earnings method
     * @return the hourly employee's earnings (hours * wage)
     */
    @Override
    public float earnings() {
        return hours * wage;
    }
}
