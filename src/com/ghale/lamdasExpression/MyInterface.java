package com.ghale.lamdasExpression;
/**
 * Creating the Functional Interface.
 * Should have only 1 abstract method.
 * Many static and default methods can be also included here.
 */
public interface MyInterface {
    /**
     * Creation of an abstract method.
     * @param text
     *
     */
    void printIt(String text);

    /**
     * Creation of default method.
     * @param s1
     * @return
     */
    default public String printThis(String s1){
        System.out.println();
        return "Hello"+ " "+ s1;

    }

    /**
     * Creation of default method.
     * @param s1
     */
    default void printingVoid(String s1){
        System.out.println("I am a default void method "+ s1);
    }

    /**
     * Creation of the static method
     * @param text
     */
    static void printingStatic(String text){
        System.out.println("This is the static method. This is your "+ text);
    }
}
