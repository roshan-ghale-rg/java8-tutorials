import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MeanMedianMode {
        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            int[] numbers = new int[number];
            for(int i= 0; i< number; i++){
                numbers[i] = scanner.nextInt();
            }
            Arrays.sort(numbers);
            double sum =0;
            int currentKey = numbers[0];
            int currentValue =0;
            int maxKey =numbers[0];
            int maxvalue= 0;
            for(int i= 0; i < numbers.length; i++){
                if(numbers[i]== currentKey){
                    currentValue++;
                    if(currentValue > maxvalue){
                        maxKey = currentKey;
                        maxvalue = currentValue;
                    }

                }else{
                    currentKey = numbers[i];
                    currentValue = 1;
                }
                sum =sum+numbers[i];
            }
            double mean = sum/number;
            double median = 0.0;
            int position =(int)((number+1)*0.5);

            if((number+1) % 2 == 1){
                median = (numbers[position]+numbers[position-1])*0.5;
            }
            else{
                median = numbers[position];
            }
            System.out.println(mean);
            System.out.println(median);
            System.out.println(maxKey);
        }

    }

}

