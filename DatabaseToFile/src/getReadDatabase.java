import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getReadDatabase {

	public static void getDataFromDataBase() throws ClassNotFoundException,
			SQLException, IOException {

		ArrayList<Kisi> kisilist = new ArrayList<Kisi>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@KZL-JA38402-B11.baogrenci.com:1521:XE",
				"C##JA3_USER", "Password01");
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("select * from TEST ");
		while (rs.next()) {

			Kisi k1 = new Kisi();
			k1.setName(rs.getString("NAME"));
			k1.setSurname(rs.getString("SURNAME"));
			k1.setYas(rs.getInt("AGE"));
			kisilist.add(k1);
			

		}
		writeIntoFile(kisilist);
		
		connection.close();
		
	}

	public static void writeIntoFile(ArrayList<Kisi> kisiList) throws IOException {

		PrintWriter bufferedWriter = null;

		bufferedWriter = new PrintWriter(new FileWriter(
				"C:\\Users\\kursad.aydin\\Desktop\\dosya.txt"));
		
		for (int j = 0; j < kisiList.size(); j++) {
			
			bufferedWriter.write(j +". Kişinin adı");
			bufferedWriter.write(kisiList.get(j).getName());
			
		}
		bufferedWriter.close();
		
	}
	
	
	
}
