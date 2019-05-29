package com.ghale.lamdasExpression;

public class LamdaExpression2 {

    private String memberVariable;
    static String staticMemVariable = " static member Variable";

    public static void main(String[] args) {
        /**
         * Creating a local variable within a function has to be manipulated inside the
         * lamda expression then the local variable has to be final.
         * Java Lambda Expressions cannot have their own state, like other classes can.
         * The only way a Java lambda expression can have any kind of internal state is
         * by referencing a variable declared outside the lamdba expression. This
         * explains how that is done, and the rules for doing so.
         */
         String a = "local variable";


        MyInterface myInterface = text -> {
            /**
             * a is a local variable that has to be defined as final inside lamda function.
             */
            String b= text+ " with "+ a;
            //a= "pp"; //this cannot be done.
            System.out.println("This is abstract method "+ b+" ");
            staticMemVariable ="changing the static variable"; /*This can be done*/


        };
        myInterface.printIt("Roshan ghale");
        myInterface.printingVoid("Hello World void");
        System.out.println(myInterface.printThis("Batman"));
        /**
         * Directly access to the static method through the classname.
         */
        MyInterface.printingStatic("static text");
    }
}
