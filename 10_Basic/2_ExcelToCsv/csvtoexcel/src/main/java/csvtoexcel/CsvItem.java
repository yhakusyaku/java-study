package csvtoexcel;

import com.opencsv.bean.CsvBindByPosition;

/**
 * CSVファイル読込クラス
 * @author okuda
 *
 */
public class CsvItem {

	/**
	 * 1カラム目
	 */
    @CsvBindByPosition(position = 0)
    private String col1 = null;

	/**
	 * 2カラム目
	 */
    @CsvBindByPosition(position = 1)
    private String col2 = null;

	/**
	 * 3カラム目
	 */
    @CsvBindByPosition(position = 2)
    private String col3 = null;

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

}
