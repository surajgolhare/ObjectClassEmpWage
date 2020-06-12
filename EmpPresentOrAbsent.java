class EmpPresentOrAbsent{
        final int IS_FULL_TIME=1;
    void GetRandom(){
        double empCheck = Math.floor(Math.random() * 10) % 2;
         if  (empCheck == IS_FULL_TIME )
              System.out.println("emp is present");
         else
              System.out.println("emp is absent");

         }


     public static void main(String[] args){
         EmpPresentOrAbsent Random = new EmpPresentOrAbsent();
         Random.GetRandom();

      }
}
