package com.blundell.checks;

import com.puppycrawl.tools.checkstyle.api.*;

public class AntiHungarianCheck extends Check {

    private static final String CATCH_MSG = "Hungarian notation belongs in the 90's. " +
    		                                "Don't prefix member variables with 'm'. " +
    		                                "Use your IDE's shiny colors. Culprit was: ";

    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.VARIABLE_DEF};
    }

    @Override
    public void visitToken(DetailAST aAST) {
       DetailAST identifier = aAST.findFirstToken(TokenTypes.IDENT);
       String varName = identifier.toString();
       System.out.println("CHECK");
       System.out.println(varName);
       String varNameAsLower = identifier.toString().toLowerCase();

       if(varName.startsWith("m") && !varName.equals(varNameAsLower)){
           log(aAST.getLineNo(), CATCH_MSG + varName);
       }
    }

}
