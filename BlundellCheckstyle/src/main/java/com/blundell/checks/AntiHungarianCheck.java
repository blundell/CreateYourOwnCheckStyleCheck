package com.blundell.checks;

import com.puppycrawl.tools.checkstyle.api.*;

public class AntiHungarianCheck extends Check {

    private static final String CATCH_MSG = "Hungarian notation belongs in the 90's. " +
    		                                "Don't prefix member variables with 'm'. " +
    		                                "Use your IDE's shiny colors. Culprit was: ";

    private final HungarianStyleDetector detector = new HungarianStyleDetector();

    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.VARIABLE_DEF};
    }

    @Override
    public void visitToken(DetailAST aAST) {
        String variableName = findVariableName(aAST);
        if (itsAFieldVariable(aAST) && detector.detectsHungarianNotation(variableName)) {
            reportStyleError(aAST, variableName);
        }
    }

    private String findVariableName(DetailAST aAST) {
        DetailAST identifier = aAST.findFirstToken(TokenTypes.IDENT);
        return identifier.toString();
    }

    private boolean itsAFieldVariable(DetailAST aAST) {
        return aAST.getParent().getType() == TokenTypes.OBJBLOCK;
    }

    private void reportStyleError(DetailAST aAST, String variableName) {
        log(aAST.getLineNo(), CATCH_MSG + variableName);
    }

}
