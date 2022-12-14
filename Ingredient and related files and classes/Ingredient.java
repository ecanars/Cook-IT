public class Ingredient {
    private String name;
    /** 
     * 0 for unit 
     * 1 for kilo
     * 2 for volume
     * 3 for glass
     */
    private int inputType;
    private int conversion;
    

    public Ingredient(String name, int inputType, int conversion) {
        this.name = name;
        this.inputType = inputType;
        this.conversion = conversion;
    }

    /*
    public double getAsGlass() {
        
    }

    public double getAsKilo() {

    }

    public double getAsVolume() {

    }

    public int getAsUnit() {

    }
    */

    public String toString() {
        return name + " " + inputType + " " + conversion;
    }

    public int getConversion() {
        return conversion;
    }

    public void setConversion(int conversion) {
        this.conversion = conversion;
    }

    public int getInputType() {
        return inputType;
    }


    public void setInputType(int inputType) {
        this.inputType = inputType;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}