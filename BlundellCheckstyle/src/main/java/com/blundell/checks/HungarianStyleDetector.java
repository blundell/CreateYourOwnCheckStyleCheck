package com.blundell.checks;

class HungarianStyleDetector {

    public boolean detectsHungarianNotation(String variableName) {
        return variableName.startsWith("m") && isVaguelyCamelCase(variableName);
    }

    private boolean isVaguelyCamelCase(String varName) {
        if (allLowerCase(varName)) {
            return false;
        }

        if (varName.length() == 1) {
            return false;
        }

        return Character.isUpperCase(varName.charAt(1));
    }

    private boolean allLowerCase(String varName) {
        String varNameAsLower = varName.toLowerCase();

        return varName.equals(varNameAsLower);
    }
}
