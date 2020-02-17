package csvtoexcel;

public class ApplicationMain {

	public static void main(String[] args) {

		try {
			//CSVファイルからデータをExcelファイルに出力
			CsvToExcel.ExecuteXls(".\\input\\test.csv", ".\\output\\test.xls");

			//ExcelファイルからデータをCSVファイルに出力

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
