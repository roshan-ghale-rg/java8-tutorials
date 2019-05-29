package com.ghale.lamdasExpression;

import java.util.Comparator;

public class LamdaExpression1 {

    public static void main(String[] args) {
        Comparator<String> lamdaComp = (s1, s2) -> {
           return s1.compareTo(s2);

        };
        System.out.println("Comparator--> "+lamdaComp.compare("Roshan","Ghale"));
        System.out.println("Reversed--->"+lamdaComp.reversed().compare("Ghale","Roshan"));
        /**
         * Creation of the lamda Object
         */
        MyFunction myInterface = (s1, s2) ->{
            return s1+" "+s2;
        };
        System.out.println("Interface Implementation first::: "+ myInterface.apply("Roshan", "Ghale"));
        /**
         * Referencing to same lamda Object and reassigning the variables and calling it.
         */
        MyFunction myInterface1 = myInterface;
        System.out.println("Referencing to the lamda Object::: "+myInterface1.apply("Hello","World"));
    }
}
