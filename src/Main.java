public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.dataOfEmployee(employeeBook.getEmployees());
        employeeBook.findEmployeeWithMinSalary(employeeBook.getEmployees());
        employeeBook.findEmployeeWithMaxSalary(employeeBook.getEmployees());
        employeeBook.findAverageSalary(employeeBook.getEmployees());
        employeeBook.findSumOfSalaryForMonth(employeeBook.getEmployees());
        employeeBook.printFullNameOfEmployees(employeeBook.getEmployees());

        employeeBook.indexSalary(employeeBook.getEmployees(), 0.05);
        employeeBook.findEmployeeWithMinSalary(employeeBook.getEmployees(), 2);
        employeeBook.findEmployeeWithMaxSalary(employeeBook.getEmployees(), 2);
        employeeBook.findSumOfSalaryForMonth(employeeBook.getEmployees(), 2);
        employeeBook.findAverageSalary(employeeBook.getEmployees(), 2);
        employeeBook.indexTheSalary(employeeBook.getEmployees(), 2, 0.05);
        employeeBook.dataOfEmployee(employeeBook.getEmployees());
        employeeBook.dataOfEmployee(employeeBook.getEmployees(), 2);

        employeeBook.deleteEmployee(employeeBook.getEmployees(),3);
        employeeBook.getEmployeeForId(employeeBook.getEmployees(),4);
        employeeBook.findOpenSpace(employeeBook.getEmployees());
        Employee welder = new Employee("Мурзинов Павел Прокофьевич", 2, 150000.0);
        employeeBook.addNewEmployee(employeeBook.getEmployees(), welder);
        employeeBook.dataOfEmployee(employeeBook.getEmployees());
        employeeBook.dataOfEmployee(employeeBook.getEmployees(), 2);
        employeeBook.compareSalaryLessArgs(employeeBook.getEmployees(),150000.0);
        employeeBook.compareSalaryMoreArgs(employeeBook.getEmployees(),150000.0);
    }
}
