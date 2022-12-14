import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Ingredient[] ingredients = new Ingredient[50];
        readIngredientTypes("ingredients.txt", ingredients);
        for (int i = 0; i < ingredients.length; i++) {
            System.out.println(ingredients[i]);
        }
    }

    public static void fillIngredientTypesList(String filename, Ingredient[] ingredients) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()) {
            Ingredient i = new Ingredient(scan.next(), scan.nextInt(), scan.nextInt());
            ingredients[count] = i;
            count++;
        }
        scan.close();
    }
}
