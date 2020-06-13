 public class CompanyWage{
        private static final int IS_FULL_TIME = 1;
        private static final int IS_PART_TIME = 2;

        private final int wagePerHr;
        private final int dayHr;
        private final int partTimeHr;
        private final int maxWorkingDay;
        private final int maxWorkingHr;
        private final String company;
         public CompanyWage(String company, int wagePerHr, int dayHr, int partTimeHr, int maxWorkingDay, int maxWorkingHr){
                this.company = company;
                this.wagePerHr = wagePerHr;
                this.dayHr = dayHr;
                this.partTimeHr = partTimeHr;
                this.maxWorkingDay = maxWorkingDay;
                this.maxWorkingHr = maxWorkingHr;
        }
        public int EmpHr(){
                int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
                switch(empCheck){
                        case 1:
                                return dayHr;
                        case 2:
                                return partTimeHr;
                }
                return 0;
        }
         public int TotalEmployeeWage(){
                int totalWage = 0;
                int workingDay = 0;
                int workingHr = 0;
                while (workingDay < maxWorkingDay && workingHr < maxWorkingHr){
                        int empHr = EmpHr();
                        int dailyWage = 0;
                        dailyWage = wagePerHr * empHr;
                        totalWage = totalWage + dailyWage;
                        ++workingDay;
                        workingHr = workingHr + empHr;
                }
                if (workingHr > maxWorkingHr)
                        return wagePerHr * maxWorkingHr;
                return totalWage;
        }
        public static void main(String[] args){
                CompanyWage empDMart = new CompanyWage("DMart", 20, 10, 5, 22, 100);
                CompanyWage empReliance = new CompanyWage("Reliance", 24, 9, 6, 25, 120);
                CompanyWage empBigBasket = new CompanyWage("BigBasket", 20, 7, 5, 24, 110);
                System.out.println("Company Name: "+ empDMart.company);
                System.out.println("monthy wage is: "+empDMart.TotalEmployeeWage());
                System.out.println("Company Name: "+ empReliance.company);
                System.out.println("monthy wage is: "+ empReliance.TotalEmployeeWage());
                System.out.println("Company Name: "+ empBigBasket.company);
                System.out.println("monthy wage is: "+ empBigBasket.TotalEmployeeWage());
        }
}

