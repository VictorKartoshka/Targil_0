/**
 * Abstract class representing an employee
 */
public abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;

    /**
     * Constructor with all fields
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param id the employee's ID number
     */
    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Default constructor
     */
    public Employee() {
        this.firstName = "Plony";
        this.lastName = "Almony";
        this.id = 0;
    }

    /**
     * Get the employee's first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the employee's first name
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the employee's last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the employee's last name
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the employee's ID
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the employee's ID
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Override of toString method
     * @return a string representation of the employee
     */
    @Override
    public String toString() {
        return "Employee: " + firstName + " " + lastName + ", ID: " + id;
    }

    /**
     * Override of equals method
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        if (id != employee.id) return false;
        if (!firstName.equals(employee.firstName)) return false;
        return lastName.equals(employee.lastName);
    }

    /**
     * Abstract method to calculate employee earnings
     * @return the employee's earnings
     */
    public abstract float earnings();
}






