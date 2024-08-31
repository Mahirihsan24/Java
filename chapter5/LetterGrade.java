import java.util.Scanner;

public class LetterGrade {

    public static void main(String[] args) {

        int total = 0;
        int gradeCounter = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n!=0) 
        {
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;

            switch(grade/10) 
            {
                case 9:  
                case 10:  
                    ++aCount;
                    break; 
                case 8:  
                    ++bCount;
                    break; 
                case 7:  
                    ++cCount;
                    break; 
                case 6: 
                    ++dCount;
                    break; 
                default: 
                    ++fCount;
                    break; 
            }
            n--;
        }
        System.out.println("\nGrade Report: \n");
        
        if (gradeCounter != 0) 
        {
            double average = (double) total / gradeCounter; 
            System.out.println("Total : "+total);
            System.out.println("Average : "+average);
            System.out.println("A : "+aCount+"\nB : "+bCount+
                    "\nC : "+cCount+"\nD : "+dCount+"\nF : "+fCount);
        }
        else
        {
            System.out.println("No Grades Entered");
        }
    }
}