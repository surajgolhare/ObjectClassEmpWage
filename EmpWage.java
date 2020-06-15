import java.util.ArrayList;
public interface IEmployeeWage{
        public void addCompanyEmployee(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr);
        public void computeEmployeeWage();
        public void getTotalEmployeeWage(Company company);
        public static final int PRESENT = 1;
        public static final int PARTTIME = 2;
}


public class Company{
        public final String company;
        public final int wagePerHr;
        public final int dayHr;
        public final int partTimeHr;
        public final int maxWorkingDay;
        public final int maxWorkingHr;
        public int totalWage;
        public ArrayList<Integer> dailyWage = new ArrayList<Integer>();

        public Company(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr){
                this.company = company;
                this.wagePerHr = wagePerHr;
                this.dayHr = dayHr;
                this.partTimeHr = partTimeHr;
                this.maxWorkingDay = maxWorkingDay;
                this.maxWorkingHr = maxWorkingHr;
        }
        public void getTotalWage(int totalWage){
                this.totalWage = totalWage;
        }
        public void storeDailyWage(ArrayList<Integer> dailyWage )
        {
                this.dailyWage = dailyWage;
        }
}
        public class EmpWage implements IEmployeeWage{
        private ArrayList<Company> companyArray;
        private int numberOfEmployee = 0;

        public EmployeeWage(){
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
                        getTotalEmployeeWage(companyArray.get(i));
                        System.out.println("Company: "+companyArray.get(i).company+ " Employee Wage :"+companyArray.get(i).totalWage);
                        int pastWage = 0;
                        System.out.println("Day      TodayWage         Total Wage");
                        for (int j=0; j<companyArray.get(i).dailyWage.size(); j++){

                                System.out.println("Day: "+ j +"\t\t"+(companyArray.get(i).dailyWage.get(j)-pastWage)+"\t\t"+companyArray.get(i).dailyWage.get(j));
                                pastWage = companyArray.get(i).dailyWage.get(j);
                        }
                }
        }

         public void getTotalEmployeeWage(Company company){
                int totalWage = 0, workingDay = 0, workingHr = 0;
                ArrayList<Integer> dailyWageArray = new ArrayList<Integer>();
                while (workingDay < company.maxWorkingDay && workingHr < company.maxWorkingHr){
                        int empHr = getEmpHr(company);
                        int dailyWage = 0;
                        dailyWage = company.wagePerHr * empHr;
                        totalWage = totalWage + dailyWage;
                        dailyWageArray.add(totalWage);
                        ++workingDay;
                        workingHr = workingHr + empHr;
                }
                if (workingHr > company.maxWorkingHr)
                        company.getTotalWage(totalWage);
                company.storeDailyWage(dailyWageArray);
                company.getTotalWage(totalWage);
        }

        public static void main(String[] args){
                EmpWage employeeWage = new EmpWage();
                employeeWage.addCompanyEmployee("DMart", 20, 8, 4, 20, 100);
                employeeWage.addCompanyEmployee("Reliance", 24, 9, 5, 25, 120);
                employeeWage.addCompanyEmployee("BigBasket", 20, 8, 5, 24, 120);
                employeeWage.computeEmployeeWage();
        }
}

