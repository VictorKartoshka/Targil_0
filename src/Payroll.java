import Employee.Employee;
import Employee.HourlyEmployee;
import Employee.CommissionEmployee;
import Employee.BasePlusCommissionEmployee;

/**
 * Class to test the employee hierarchy
 */
public class Payroll {
    /**
     * Main method to test the employee hierarchy
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create an array of Employee.Employee objects
        Employee[] employees = new Employee[3];

        // Initialize employees with realistic values
        employees[0] = new HourlyEmployee("Moshe", "Cohen", 123456789, 40, 60.50f);
        employees[1] = new CommissionEmployee("Sarah", "Levi", 987654321, 20000.0f, 5);
        employees[2] = new BasePlusCommissionEmployee("David", "Israeli", 555555555, 15000.0f, 4, 3000.0f);

        // Print information for each employee
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

            // Add 10% bonus to base salary if the employee is a Employee.BasePlusCommissionEmployee
            if (employees[i] instanceof BasePlusCommissionEmployee employee) {
                float currentBaseSalary = employee.getBaseSalary();
                employee.setBaseSalary(currentBaseSalary * 1.1f);
                System.out.println("After 10% bonus: " + employee);
            }

            System.out.println(); // Empty line for better readability
        }
    }
}