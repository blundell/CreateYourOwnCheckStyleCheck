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
        if (itsAFieldVariable(aAST)) {
            DetailAST identifier = aAST.findFirstToken(TokenTypes.IDENT);
            String varName = identifier.toString();

            if (memberVariableIsPrefixedWithTheHungarianNotationForMemberVariable(varName)) {
                log(aAST.getLineNo(), CATCH_MSG + varName);
            }
        }
    }

    private boolean itsAFieldVariable(DetailAST aAST) {
        return aAST.getParent().getType() == TokenTypes.OBJBLOCK;
    }

    /**
     * Someone please replace this with a sexy reg ex
     * @param varName variable under test
     * @return true if the variable is prefixed with a lower case m followed by camel case
     */
    private boolean memberVariableIsPrefixedWithTheHungarianNotationForMemberVariable(String varName) {
        return varName.startsWith("m") && isVaguelyCamelCase(varName);
    }

    private boolean isVaguelyCamelCase(String varName) {
        if(allLowerCase(varName)){
            return false;
        }

        if(varName.length() == 1){
            return false;
        }

        return Character.isUpperCase(varName.charAt(1));
    }

    private boolean allLowerCase(String varName) {
        String varNameAsLower = varName.toLowerCase();

        return varName.equals(varNameAsLower);
    }

}
