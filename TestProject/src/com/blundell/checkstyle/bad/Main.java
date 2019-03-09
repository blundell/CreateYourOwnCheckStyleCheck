package com.blundell.checkstyle.bad;

public class Main {

    public static final int AMOUNT_OF_HUNGARIAN_MEMBER_ERRORS = 6;

    public static final int CONST = 0; // OK
    public static final int M_CONST = 0; // OK
    public static final int MY_CONST = 0; // OK

    private final String mFoo; // Not OK
    public int mFooBar;        // Not OK
    public String mMmMmMm;     // Not OK
    public int mVar1;          // Not OK
    public int mFoo1Bar;       // Not OK
    public int mT;             // Not OK
    public int mooFooBar;      // OK
    public String mmmmm;       // OK
    public int var1;           // OK
    public int moo;            // OK
    public int foo1Bar;        // OK

    public Main() {
        mFoo = "dfsdf";
    }

    /**
     * Method scope vars should not be tested
     */
    public void doSomething(String mmm){
        String mmmm = mmm; // OK

        int mooFoo = 0; // OK
        int mT = 0; // method scope so OK
        int normalCamelCase = 0; // OK
        int camelCaseWith2Number2s = 0; // OK

        System.out.println(mooFoo + mmmm + mT + mFoo + normalCamelCase + camelCaseWith2Number2s);
    }

}
