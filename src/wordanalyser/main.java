
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordanalyser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Version;
import org.tartarus.snowball.ext.PorterStemmer;

/**
 *
 * @author Ali Souri
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String... aArgs) throws IOException {
        main text = new main();
        text.textDataAnalyser(text);
    }
    final static String FILE_NAME = "C:\\Users\\Ali Souri\\Desktop\\Work\\Dr.Bany\\wordAnalyser\\src\\wordanalyser\\pasage.txt";
    final static String OUTPUT_FILE_NAME = "C:\\Users\\Ali Souri\\Desktop\\Work\\Dr.Bany\\wordAnalyser\\src\\wordanalyser\\output.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;
    private long[] c;

    public String textDataAnalyser(main handler) throws IOException {
        List<String> lines = handler.readTextFile(FILE_NAME);
        int size = 0;
        String currentLine[] = null;
        String primaryArray[] = {""};
        List<String> writeList = new ArrayList(Arrays.asList(primaryArray));
        try {
            for (int i = 0; i < lines.size(); i++) {
                log("The Answer Of Student With Number " + i + " In Original Mode:" + lines.get(i));
                String answerStemed = stopAndStem(lines.get(i));
                log("The Answer Of Student With Number " + i + " In Stem Mode:" + answerStemed);
                writeList.add(answerStemed);
                currentLine = lines.get(i).split(" ");
                size = size + currentLine.length;
            }
            System.out.println("The size of words is:" + size);
            writeList.remove(0);
            writelTextFile(writeList, OUTPUT_FILE_NAME);
        } catch (Exception e) {
            System.out.println("The Exception Of textDataAnalyser:");
            System.out.println(e);
        }
        return Arrays.toString(c);
    }

    List<String> readTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }

    private String stopAndStem(String line) throws IOException {
        Version matchVersion = Version.LUCENE_CURRENT; // Substitute desired Lucene version for XY
        Analyzer analyzer = new StandardAnalyzer(matchVersion); // or any other analyzer
        ArrayList<String> endList = new ArrayList<>();
        TokenStream ts = analyzer.tokenStream("myfield", new StringReader(line));
        OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);
        try {
            ts.reset(); // Resets this stream to the beginning. (Required)
            while (ts.incrementToken()) {
                //PorterStemFilter psf = new PorterStemFilter(ts);
                String condidateStr = subStr(line, offsetAtt.startOffset(), offsetAtt.endOffset());
                String stemStr = stemmer(condidateStr);
                endList.add(stemStr);
            }
            ts.end();
            // Perform end-of-stream operations, e.g. set the final offset.
        } catch (Exception e) {
            System.out.println("OMG!");
            System.out.println(e);
        } finally {
            ts.close(); // Release resources associated with this stream.
        }
        Object[] cordata = endList.toArray();
        return Arrays.toString(cordata);
    }

    public static String subStr(String ins, int start, int end) {
        String ret = ins.substring(start, end);
        return ret;
    }

    private static String stemmer(String word) {
        PorterStemmer obj = new PorterStemmer();
        obj.setCurrent(word);
        obj.stem();
        return obj.getCurrent();
    }

    void writelTextFile(List<String> aLines, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, ENCODING);
    }
    
    private static void log(Object aMsg) {
        System.out.println(String.valueOf(aMsg));
    }
}
