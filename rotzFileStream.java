import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class rotzFileStream {

    public static void writeTofile(String dn, String di) throws IOException {
        FileWriter fw;
        fw = new FileWriter(dn);
		fw.write(di);
		fw.close();
    }

    public static String readFromFile(String dn) throws IOException {
        FileReader fr;
        int charCode;
        String outputString = "";
        fr = new FileReader(dn);
        charCode = fr.read();
        while(charCode != -1) {
            outputString += Character.toString((char) charCode);
            charCode = fr.read();
        }
        fr.close();
        return outputString;
    }

    public static String readLineFromFile(String dn, int l) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(dn));
        String outputString = "";
        for(int i = 0; i < l; i++) {
            br.readLine();
        }
        outputString = br.readLine();
        br.close();
        return outputString;
    }

}