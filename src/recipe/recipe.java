package recipe;

import java.util.HashMap;

import ingredients.ingredient;

public class recipe {

    HashMap<ingredient, Integer> recipeInstruction = new HashMap<ingredient, Integer>();
    String recipeName = "";

    public recipe(HashMap<ingredient, Integer> recipeInstruction, String recipeName) {
        this.recipeInstruction = recipeInstruction;
        this.recipeName = recipeName;
    }

    public HashMap<ingredient, Integer> getRecipeInstruction() {
        return this.recipeInstruction;
    }

    public void setRecipeInstruction(HashMap<ingredient, Integer> recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

}
