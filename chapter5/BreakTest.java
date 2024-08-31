public class BreakTest {
    public static void main(String[] args) {

        int count;
        for(count=1; count<=10; count++)
        {
            if(count == 5)
                break;
            System.out.println(count);
        }

        System.out.println("Broke out of loop at count = "+count);
    }

}