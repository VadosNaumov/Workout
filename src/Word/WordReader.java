package Word;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.util.List;

public class WordReader {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("/home/vadim/Документы/word2.docx")) {

            // открываем файл и считываем его содержимое в объект XWPFDocument
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));

            // печатаем содержимое всех параграфов документа в консоль
            List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
            for (XWPFParagraph p : paragraphs) {
                System.out.println(p.getText());
            }

//            System.out.println("_____________________________________");
//            // печатаем все содержимое Word файла
//            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
//            System.out.println(extractor.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
