import java.util.ArrayList;
public interface IEmployeeWage{
        public static final int PRESENT = 1;
        public static final int PARTTIME = 2;
        public void addCompanyEmployee(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr);
        public void computeEmployeeWage();
        public int getTotalEmployeeWage(Company company);
}

public class EmpWage implements IEmployeeWage{

        private ArrayList<Company> companyArray;
        private int numberOfEmployee = 0;

        public EmpWage(){
                companyArray = new ArrayList<Company>();
        }

        public void addCompanyEmployee(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr){
                Company comp = new Company(company, wagePerHr, dayHr, partTimeHr, maxWorkingDay, maxWorkingHr);
                companyArray.add(comp);
                numberOfEmployee++;
        }

        public int getEmpHr(Company comp){
                int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
                switch(empCheck){
                        case 1:
                                return comp.dayHr;
                        case 2:
                                return comp.partTimeHr;
                }
                return 0;
        }

        public void computeEmployeeWage(){
                for (int i=0; i< numberOfEmployee; i++){
                        System.out.println("Company: "+companyArray.get(i).company+ " Employee Wage :"+getTotalEmployeeWage(companyArray.get(i)));
                }
        }

        public int getTotalEmployeeWage(Company company){
                int totalWage = 0;
                int workingDay = 0;
                int workingHr = 0;
                while (workingDay < company.maxWorkingDay && workingHr < company.maxWorkingHr){
                 int empHr = getEmpHr(company);
                        int dailyWage = 0;
                        dailyWage = company.wagePerHr * empHr;
                        totalWage = totalWage + dailyWage;
                        ++workingDay;
                        workingHr = workingHr + empHr;
                }
                if (workingHr > company.maxWorkingHr)
                        return company.wagePerHr * company.maxWorkingHr;
                return totalWage;
 }
        public class Company{
        public final String company;
        public final int wagePerHr;
        public final int dayHr;
        public final int partTimeHr;
        public final int maxWorkingDay;
        public final int maxWorkingHr;

        public Company(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr){
                this.company = company;
                this.wagePerHr = wagePerHr;
                this.dayHr = dayHr;
                this.partTimeHr = partTimeHr;
                this.maxWorkingDay = maxWorkingDay;
                this.maxWorkingHr = maxWorkingHr;
        }

}
        public static void main(String[] args){
                EmpWage employeeWage = new EmpWage();
                employeeWage.addCompanyEmployee("DMart", 20, 8, 4, 20, 100);
                employeeWage.addCompanyEmployee("Reliance", 24, 9, 5, 25, 120);
                employeeWage.addCompanyEmployee("BigBasket", 20, 8, 5, 24, 120);
                employeeWage.computeEmployeeWage();
        }
}

