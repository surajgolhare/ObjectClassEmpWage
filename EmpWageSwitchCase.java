class EmpWageSwitchCase{
        final int IS_FULL_TIME=1;
        final int IS_PART_TIME=2;
        final int EMP_RATE_PER_HR=20;
              int EMP_HR=0;
              int EMP_WAGE=0;
       int GetRandom() {
             int empCheck = (int)Math.floor(Math.random() * 10 ) % 3;
             switch (empCheck) {
                 case 1:
                         return 8;
                 case 2:
                         return 4;
                 default:
                         return 0;
            }
       }
       void EmpWageCal() {
                EMP_HR=GetRandom();
                EMP_WAGE=EMP_HR*EMP_RATE_PER_HR;
                System.out.println( EMP_WAGE);
        }
     public static void main(String[] args){
         EmpWageSwitchCase random = new EmpWageSwitchCase();
              random.EmpWageCal();
      }

}

