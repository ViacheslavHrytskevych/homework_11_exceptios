import java.util.Arrays;

public class ArrayValueCalculator {

    public static void main(String[] args) {
        String[][] numbers = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1"}};

        ArrayValueCalculator calculator = new ArrayValueCalculator();

        try {
            int sum = calculator.doCalc(numbers);
            System.out.println("Sum: " + sum);
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public int doCalc(String[][] numbers) throws ArraySizeException, ArrayDataException {
        if (!Arrays.stream(numbers).allMatch(row -> row.length == 4)) {
            throw new ArraySizeException("The array size must be 4x4.");
        }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    sum += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + numbers[i][j], i, j, e);                }
            }
        }

        return sum;
    }
}