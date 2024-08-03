public class Main {
    public static void main(String[] args) {
        Employee employee[] = {EmployeeTest.generalManager, EmployeeTest.directorOfProduction,
                EmployeeTest.mainEngineer, EmployeeTest.engineer, EmployeeTest.estimator,
                EmployeeTest.salesSpecialist, EmployeeTest.economist, EmployeeTest.secretary,
                EmployeeTest.accountant, EmployeeTest.worker};

        dataOfEmployee(employee);
        findEmployeeWithMinSalary(employee);
        findEmployeeWithMaxSalary(employee);
        findAverageSalary(employee);
        findSumOfSalaryForMonth(employee);
        printFullNameOfEmployee(employee);
    }

        // Получить список всех сотрудников со всеми имеющимися данными
        public static void dataOfEmployee (Employee employee[]){
            for (int id = 0; id < employee.length; id++) {
                if(employee[id] != null) {
                    System.out.println(employee[id].toString());
                }
            }
        }

        // Сумма затрат на ЗП в месяц
        public static double findSumOfSalaryForMonth (Employee employee[]){
            double sum = 0;
            for (int id = 0; id < employee.length; id++) {
                if (employee[id] != null) {
                    sum += employee[id].getSalary();
                }
            }
            return sum;
        }


        // Найти сотрудника с минимальной ЗП
        public static Employee findEmployeeWithMinSalary (Employee employee[]){
            int id;
            int idMin = 0;
            double minSalary = employee[0].getSalary();
            for (id = 1; id < employee.length; id++) {
                if (employee[id].getSalary() < minSalary) {
                    minSalary = employee[id].getSalary();
                    idMin = id;
                }
            }
            return employee[idMin];
        }

        // Найти сотрудника с максимальной ЗП
        public static Employee findEmployeeWithMaxSalary (Employee employee[]){
            int id;
            int idMax = 0;
            double maxSalary = employee[0].getSalary();
            for (id = 1; id < employee.length; id++) {
                if (employee[id].getSalary() > maxSalary) {
                    maxSalary = employee[id].getSalary();
                    idMax = id;
                }
            }
            return employee[idMax];
        }

        // Средняя заработная плата
        public static double findAverageSalary (Employee employee[]) {
            int exactCount = 0;
            for (int id = 0; id < employee.length; id++) {
                if (employee[id] != null) {
                    exactCount++;
                }
            }
            return findSumOfSalaryForMonth(employee) / exactCount;
        }

        // Распечатать ФИО всех сотрудников
        public static void printFullNameOfEmployee (Employee employee[]){
            for (int id = 0; id < employee.length; id++) {
                System.out.println(employee[id].getFullName());
            }
        }
}


