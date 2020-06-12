class EmpDailyWage{
        final int IS_FULL_TIME=1;
        final int EMP_RATE_PER_HR=20;
              int EMP_HR=0;
              int EMP_WAGE=0;
       int GetRandom() {
       double empCheck = Math.floor(Math.random() * 10 ) %2;
         if  (empCheck == IS_FULL_TIME )
              return 8;
         else
               return 0;
         }
       void EmpWageCal() {
                EMP_HR=GetRandom();
                EMP_WAGE=EMP_HR*EMP_RATE_PER_HR;
                System.out.println(EMP_WAGE);
        }
     public static void main(String[] arrgs){
         EmpDailyWage random = new EmpDailyWage();
              random.EmpWageCal();
      }

}


