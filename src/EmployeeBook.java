/*
public class EmployeeBook {


    public static Employee[] getEmployees() {
        return employees;
    }


*/
/*
  EmployeeBook employeeBook = new EmployeeBook();

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
  */

/*



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
*/
