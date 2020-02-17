package csvtoexcel;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opencsv.bean.CsvToBeanBuilder;


public class CsvToExcel {

	/**
	 * CSVファイルからExcelファイルにデータ出力(旧フォーマット)
	 * @param fromPath
	 * @param toPath
	 * @throws Exception
	 */
	public static void ExecuteXls(String fromPath,String toPath) throws Exception
	{
		//-----------------------------
		//CSVファイル読込
		//-----------------------------
		// java.util.List に CsvItem格納するための変数を定義
		List<CsvItem> list = null;


		// ファイル読取
		//-----------------------------
		// テキストファイル読込は、基本パターン
		// FileInputStream,文字コード指定->InputStreamReader->BufferedReaderにすることで、
		// 内部バッファが利用されるようになり、一度に大きなファイルを開いてしまいメモリが足りなくなることや
		// 処理速度低下を未然に防ぐ作用があります。
		//
		// また、try構文を使うことで、変数が利用されなくなると自動的にクローズされれ、
		// ファイルのデットロック等を防ぐことができます。

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fromPath), "UTF-8"))) {

			//今回はOpenCsvライブラリを利用しファイル読込を簡単に実施
			//https://qiita.com/vicugna-pacos/items/6bc9fa3269d0b8484c9c参考
		    CsvToBeanBuilder<CsvItem> builder = new CsvToBeanBuilder<CsvItem>(reader);
		    builder.withType(CsvItem.class);
		    list = builder.build().parse();
		}


		//-----------------------------
		// CSVファイル読込
		//-----------------------------
		// Excelブックを作成 ※HSSF (旧Excelファイルフォーマット)
		try(HSSFWorkbook workbook1 = new HSSFWorkbook())
		{
			// Excel シートを作成 ※HSSF (旧Excelファイルフォーマット)
			HSSFSheet sheet1 = workbook1.createSheet();

			for(int i = 0 ; i < list.size();i++)
			{
				// HSSF (行番号は0から始まる)
				HSSFRow row = sheet1.createRow(i);

				// cellに値を入力
				HSSFCell col1 = row.createCell(0);
				col1.setCellValue(list.get(i).getCol1());

				HSSFCell col2 = row.createCell(1);
				col2.setCellValue(list.get(i).getCol2());

				HSSFCell col3 = row.createCell(2);
				col3.setCellValue(list.get(i).getCol3());

			}

			// ファイル書込
			//-----------------------------
			// バイナリファイルも読込と同様にBufferedOutputStreamを間に入れることで、
			// 内部バッファが利用されるようになり、処理速度低下を未然に防ぐ作用があります。
			try( BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(toPath)))
			{
			     workbook1.write(writer);
			}
		}
	}

	/**
	 * CSVファイルからExcelファイルにデータ出力(新フォーマット)
	 * @param fromPath
	 * @param toPath
	 */
	public static void ExecuteXlsx(String fromPath,String toPath)
	{

	}
}
