
/**
 * finds target value
 * 
 * @author amacleod
 * @version 11192019
 */
public class Path {

    /**
     * Finds the target value
     * 
     * @param array
     *            2d array input
     * @param row
     *            rows in 2d array
     * @param column
     *            columns in 2d array
     * @param target
     *            target to find in array
     * @return directions it took to find target
     */
    public static String path(int[][] array, int row, int column, int target) {

        if (array[row][column] == target) {
            return "";
        }
        else {
            if (column + 1 < array[0].length) {
                return path(array, row, column + 1, target) + "<";

            }
            else if (row + 1 < array[1].length) {
                return path(array, row + 1, 0, target) + "v";

            }
            else if (column - 1 > array[0].length) {
                return path(array, row, column + 1, target) + ">";

            }
            else if (row - 1 > array[1].length) {
                return path(array, row - 1, column, target) + "^";

            }
            else {
                return "nah";
            }

        }
    }
}
