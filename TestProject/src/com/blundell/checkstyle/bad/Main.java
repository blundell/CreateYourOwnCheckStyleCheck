package com.blundell.checkstyle.bad;

public class Main {

    private final String mHungry;

    public Main() {
        mHungry = "dfsdf";
    }

    public void doSomething(String mmm){
        String mmmm = mmm;

        int mT = 0;
        int normalCamelCase = 0;
        int camelCaseWith2Number2s = 0;

        System.out.println(mmmm + mT + mHungry + normalCamelCase + camelCaseWith2Number2s);
    }

}
