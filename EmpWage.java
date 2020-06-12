class EmpWage{
        final int IS_FULL_TIME=1;
        final int IS_PART_TIME=2;
        final int EMP_RATE_PER_HR=20;
              int EMP_HR=0;
              int EMP_WAGE=0;
              int DAILY_WAGE=0;
              int TOTAL_WORKING_HR = 0;
              int TOTAL_WORKING_DAY = 0;
       int GetRandom() {
             int empCheck = (int)Math.floor(Math.random() * 10 ) %3;
             switch (empCheck){
                 case 1:
                         return 8;
                 case 2:
                         return 4;
                 default:
                         return 0;

             }
        }
       void EmpWageCal() {
        while( TOTAL_WORKING_HR <= 100 && TOTAL_WORKING_DAY <=20)
           {

                EMP_HR=GetRandom();
                ++TOTAL_WORKING_DAY;
                DAILY_WAGE=EMP_HR*EMP_RATE_PER_HR;
                 EMP_WAGE=EMP_WAGE+DAILY_WAGE;
                System.out.println("Emp DailyWage\tMonthly_Wage");
                System.out.println( +DAILY_WAGE+"\t\t"+EMP_WAGE+"\t\t");

       }
   }
     public static void main(String[] args){
         EmpWage random = new EmpWage();
              random.EmpWageCal();
      }

}



