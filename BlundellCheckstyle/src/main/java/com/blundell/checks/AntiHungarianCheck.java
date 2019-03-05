package com.blundell.checks;

import com.puppycrawl.tools.checkstyle.api.*;

public class AntiHungarianCheck extends AbstractCheck {

	private static final String CATCH_MSG = "Hungarian notation belongs in the 90's. "
			+ "Don't prefix member variables with 'm'. " + "Use your IDE's shiny colors. Culprit was: ";

	private final HungarianNotationMemberDetector detector = new HungarianNotationMemberDetector();

	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.VARIABLE_DEF };
	}

	@Override
	public void visitToken(DetailAST aAST) {
		String variableName = findVariableName(aAST);
		if (itsAFieldVariable(aAST) && detector.detectsNotation(variableName)) {
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

	@Override
	public int[] getAcceptableTokens() {
		return new int[] { TokenTypes.VARIABLE_DEF };
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[0];
	}

}
