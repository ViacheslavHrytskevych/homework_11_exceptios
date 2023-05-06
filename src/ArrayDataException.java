public class ArrayDataException extends Exception {
    private int rowIndex;
    private int columnIndex;

    public ArrayDataException(String message, int rowIndex, int columnIndex, Throwable cause) {
        super(message, cause);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
