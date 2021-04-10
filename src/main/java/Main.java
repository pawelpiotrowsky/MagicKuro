import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, IncorrectFileExtension {
        /// MagicNumbers excercise.
        /// File has to be in the exact folder as MagicKuro.... wip...
        ///
        String fileName = fileChooser();
        System.out.println("Checking....");
        RealHexValues realHexValues = new RealHexValues();
        String fileExtension = FilenameUtils.getExtension(fileName);
        ifFileExtensionNotCorrect(fileExtension);
        ifFileExtensionCorrect(fileName, realHexValues, fileExtension);

    }

    private static String fileChooser() throws IOException {
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);

        String path = new File(dialog.getFile()).getCanonicalPath();
        String fileChosen = dialog.getFile();
        System.out.println(path);
        String fileName = path;
        return fileName;
    }

    private static void ifFileExtensionCorrect(String fileName, RealHexValues realHexValues, String fileExtension) throws IncorrectFileExtension, IOException {
        if(fileExtension.equals("jpg"))
        isFileExtensionCorrect(realHexValues.getHexValue("jpg"), getHexValuesFromFile(fileName));
        if(fileExtension.equals("pdf"))
            isFileExtensionCorrect(realHexValues.getHexValue("pdf"), getHexValuesFromFile(fileName));
        if(fileExtension.equals("gif"))
        isFileExtensionCorrect(realHexValues.getHexValue("gif"), getHexValuesFromFile(fileName));
    }

    private static void ifFileExtensionNotCorrect(String fileExtension) throws IncorrectFileExtension {
        // sprawdzic jak to zrzutowac
        if(!fileExtension.equals("jpg") && !fileExtension.equals("pdf") && !fileExtension.equals("gif"))
            throw new IncorrectFileExtension("Wrong file to check.");
    }

    private static void isFileExtensionCorrect(String signatureHexValues, String hexValuesFromFile) throws IncorrectFileExtension{
        if (hexValuesFromFile.equals(signatureHexValues)) {
            System.out.println("File OK.");
        } else {
            throw new IncorrectFileExtension("Might be a malware.");
        }
    }

    private static String getHexValuesFromFile(String fileName) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        String hexRead = "";
        for (int i = 0; i < 4; i++) {
             hexRead = hexRead.concat(String.format("%02x", fis.read()));
        }
    return hexRead;
    }


}
