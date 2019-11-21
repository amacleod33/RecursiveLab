
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
        
        if (row - 1 < 4 && row - 1 >= 0
            && array[row - 1][column] == array[row][column] + 1) {
            return "^" + path(array, row - 1, column, target);
        }
        
        if (row + 1 < 4
            && array[row + 1][column] == array[row][column] + 1) {
            return "v" + path(array, row + 1, column, target);

        }
        
       
        if (column + 1 < 4
            && array[row][column + 1] == array[row][column] + 1) {
            return ">" + path(array, row, column + 1, target);

        }
        
        if (column - 1 < 4 && column - 1 >= 0
            && array[row][column - 1] == array[row][column] + 1) {
            return "<" + path(array, row, column - 1, target);
        }
        
       
       


        
        return "";

    }

}
