import java.util.ArrayList;

public class EmployeeBook {
    static Employee generalManager = new Employee("Пугачёва Алла Борисовна", 1, 465000.00);
    static Employee directorOfProduction = new Employee("Киркоров Филипп Бедросович", 1, 455000.00);
    static Employee mainEngineer = new Employee("Козлов Игорь Витальевич", 2, 225000.00);
    static Employee engineer = new Employee("Козлов Иван Игоревич", 2, 125000.00);
    static Employee estimator = new Employee("Бронина Виктория Васильевна", 2, 120000.00);
    static Employee salesSpecialist = new Employee("Козлов Святослав Иванович", 3, 156000.00);
    static Employee economist = new Employee("Восточная Марина Васильевна", 4, 110000.00);
    static Employee secretary = new Employee("Васильева Эльвира Альбертовна", 5, 75000.00);
    static Employee accountant = new Employee("Сухорукова Светлана Аркадьевна", 4, 138000.00);
    static Employee worker = new Employee("Сухоруков Вячеслав Викторович", 2, 120000.00);

    public static Employee[] getEmployees() {
        return employees;
    }

    private static Employee employees[] = {generalManager, directorOfProduction, mainEngineer,
            engineer, estimator, salesSpecialist, economist,
            secretary, accountant, worker};

    // Получить список всех сотрудников со всеми имеющимися данными
    public static void dataOfEmployee(Employee employee[]) {
        System.out.println("Список сотрудников компании: ");
        for (int id = 0; id < employee.length; id++) {
            System.out.println(employee[id].toString());
        }
        System.out.println("");
    }

    // Сумма затрат на ЗП в месяц
    public static double findSumOfSalaryForMonth(Employee employee[]) {
        double sum = 0;
        for (int id = 0; id < employee.length; id++) {
            sum += employee[id].getSalary();
        }
        System.out.println("\nСумма затрат на заработную плату в месяц составляет: " + sum);
        return sum;
    }


    // Найти сотрудника с минимальной ЗП
    public static Employee findEmployeeWithMinSalary(Employee employee[]) {
        int id;
        int idMin = 0;
        double minSalary = employee[0].getSalary();
        for (id = 1; id < employee.length; id++) {
            if (employee[id].getSalary() < minSalary) {
                minSalary = employee[id].getSalary();
                idMin = id;
            }
            System.out.println("\nСотрудник с минимальной заработной платой в месяц " + employee[idMin].toString());
        }
        return employee[idMin];
    }

    // Найти сотрудника с максимальной ЗП
    public static Employee findEmployeeWithMaxSalary(Employee employee[]) {
        int id;
        int idMax = 0;
        double maxSalary = employee[0].getSalary();
        for (id = 1; id < employee.length; id++) {
            if (employee[id].getSalary() > maxSalary) {
                maxSalary = employee[id].getSalary();
                idMax = id;
            }
            System.out.println("\nСотрудник с максимальной заработной платой в месяц " + employee[idMax].toString());
        }
        return employee[idMax];
    }

    // Средняя заработная плата
    public static void findAverageSalary(Employee employee[]) {
        double averageSalary = findSumOfSalaryForMonth(employee) / employee.length;
        System.out.println("\nСредняя заработная плата по компании: " + averageSalary);
    }

    // Распечатать ФИО всех сотрудников
    public static void printFullNameOfEmployees(Employee employee[]) {
        for (int id = 0; id < employee.length; id++) {
            System.out.println(employee[id].getFullName());
        }
    }


    // Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public static void indexSalary(Employee employee[], double percentageIncrease) {
        for (int id = 0; id < employee.length; id++) {
            employee[id].setSalary(employee[id].getSalary()
                    + (employee[id].getSalary() * percentageIncrease));
        }
        System.out.println("\nВыполнена индексация заработной платы," +
                "коэффициент индексации = " + percentageIncrease);
        dataOfEmployee(employee);
    }

    // Найти сотрудника с минимальной ЗП по отделу
    public static Employee findEmployeeWithMinSalary(Employee employee[], int department) {
        int id;
        int idMin = 0;
        double minSalary = employee[0].getSalary();
        if (department <= 1 && department >= 5) {
            System.out.println("\nНекорректный ввод");
        } else {
            for (id = 1; id < employee.length; id++) {
                if (employee[id].getDepartment() == department) {
                    if (employee[id].getSalary() < minSalary) {
                        minSalary = employee[id].getSalary();
                        idMin = id;
                    }
                }
            }
            System.out.println("\nСотрудник с минимальной заработной платой по отделу "
                    + department + ": " + employee[idMin].getFullName());
        }
        return employee[idMin];
    }

    // Найти сотрудника с максимальной ЗП по отделу
    public static void findEmployeeWithMaxSalary(Employee employee[], int department) {
        int id;
        int idMax = 0;
        double maxSalary = 0;
        if (department <= 1 && department >= 5) {
            System.out.println("\nНекорректный ввод");
        } else {
            for (id = 1; id < employee.length; id++) {
                if (employee[id].getDepartment() == department) {
                    if (employee[id].getSalary() > maxSalary) {
                        maxSalary = employee[id].getSalary();
                        idMax = id;
                    }
                }
            }
            System.out.println("\nСотрудник с максимальной заработной платой по отделу "
                    + department + ": " + employee[idMax].getFullName());
        }

    }

    // Сумма затрат на ЗП по отделу
    public static void findSumOfSalaryForMonth(Employee employee[], int department) {
        double sum = 0;
        if (department <= 1 && department >= 5) {
            System.out.println("\nНекорректный ввод");
        } else {
            for (int id = 0; id < employee.length; id++) {
                if (employee[id].getDepartment() == department) {
                    sum += employee[id].getSalary();
                }
            }
            System.out.println("\nСумма затрат на заработную плату в отделе "
                    + department + " в месяц составляет: " + sum);
        }
    }

    // Средняя заработная плата по отделу
    public static void findAverageSalary(Employee employee[], int department) {
        double sum = 0;
        int count = 0;
        for (int id = 0; id < employee.length; id++) {
            if (employee[id].getDepartment() == department) {
                sum += employee[id].getSalary();
                count++;
            }
        }
        double averageSalary = sum / count;
        System.out.println("\nСредняя заработная плата в отделе "
                + department + " составляет: " + averageSalary);
    }

    // Проиндексировать зарплату в отделе (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public static void indexTheSalary(Employee employee[], int department, double percentageIncrease) {
        for (int id = 0; id < employee.length; id++) {
            if (employee[id].getSalary() != 0 &&
                    employee[id].getDepartment() == department &&
                    employee[id].getFullName() != null) {
                employee[id].setSalary(employee[id].getSalary() +
                        (employee[id].getSalary() * percentageIncrease));
            }
        }
        System.out.println("\nВыполнена индексация заработной платы в отделе " + department +
                ", коэффициент индексации = " + percentageIncrease);
    }

    // напечатать всех сотрудников отдела (все данные, кроме отдела)
    public static void dataOfEmployee(Employee employee[], int department) {
        System.out.println("\nСписок сотрудников отдела " + department + ": ");
        for (int id = 0; id < employee.length; id++) {
            if (employee[id].getDepartment() == department) {
                System.out.println(employee[id].toString());
            }
        }
    }

    public static ArrayList generateArrayListToManage(Employee employee[]) {
        ArrayList<Employee> employeeNew = new ArrayList();
        for (int id = 0; id < employee.length; id++) {
            employeeNew.add(employee[id]);
        }
        return employeeNew;
    }

    //Удалить сотрудника по id, нуллим его ячейку в массиве
    public static void deleteEmployee(Employee[] employee, int index) {
        ArrayList<Employee> employeeNew = new ArrayList(generateArrayListToManage(getEmployees()));
        Employee deleteEmployeeFromArray = new Employee(null, 0, 0);
        employeeNew.set(index, deleteEmployeeFromArray);
        for (int i = 0; i < employeeNew.size(); i++) {
            employee[i] = employeeNew.get(i);
        }
    }


    //  Добавить метод для получения сотрудника по id
    public void getEmployeeForId(Employee[] employee, int id) {
        System.out.println(employee[id].toString());
    }

    static int indexOfOpenSpace = 0;
    static boolean haveOpenSpace = false;

    //Поиск свободных ячеек в массиве
    public static void findOpenSpace(Employee[] employee) {
        ArrayList<Employee> employeeNew = new ArrayList(generateArrayListToManage(employee));
        Employee openSpace = new Employee(null, 0, 0);
        for (int i = 0; i < employeeNew.size(); i++) {
            if (employeeNew.get(i).hashCode() == openSpace.hashCode()
                    && openSpace.equals(employeeNew.get(i))) {
                indexOfOpenSpace = i;
                haveOpenSpace = true;
            }
        }
        System.out.println("");
        System.out.println(haveOpenSpace);
    }


    // Добавить нового сотрудника (метод должен найти свободную ячейку в массиве и положить нового сотрудника в нее).
    public static void addNewEmployee(Employee[] employee, Employee newEmployee) {
        ArrayList<Employee> employeeNew = new ArrayList(generateArrayListToManage(employee));
        findOpenSpace(employee);
        if (haveOpenSpace == true) {
            employeeNew.set(indexOfOpenSpace, newEmployee);
        }
        employeeNew.toArray(employee);
    }

    // Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
    public static void compareSalaryLessArgs(Employee[] employee, double compareArgs) {
        int count = 0;
        ArrayList<Employee> employeeNew = new ArrayList(generateArrayListToManage(employee));
        System.out.println("\nСотрудники с заработной платой меньше, чем " + compareArgs + ": ");
        for (int i = 0; i < employeeNew.size(); i++) {
            if (employeeNew.get(i).getSalary() < compareArgs) {
                System.out.println("id: " + i + ", fullName: " + employeeNew.get(i).getFullName()
                        + ", salary: " + employeeNew.get(i).getSalary());
            }
        }
    }

    // Получить в качестве параметра число и вывести всех сотрудников с зп больше числа (распечатать id, фио и зп в консоль);
    public static void compareSalaryMoreArgs(Employee[] employee, double compareArgs) {
        int count = 0;
        ArrayList<Employee> employeeNew = new ArrayList(generateArrayListToManage(employee));
        System.out.println("\nСотрудники с заработной платой больше, чем " + compareArgs + ": ");
        for (int i = 0; i < employeeNew.size(); i++) {
            if (employeeNew.get(i).getSalary() > compareArgs) {
                System.out.println("id: " + i + ", fullName: " + employeeNew.get(i).getFullName()
                        + ", salary: " + employeeNew.get(i).getSalary());
            }
        }
    }
}
