//package wordanalyser;
//
//
//import java.io.Reader;
//import java.util.Set;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.analysis.core.LowerCaseTokenizer;
//import org.apache.lucene.analysis.core.StopAnalyzer;
//import org.apache.lucene.analysis.core.StopFilter;
//import org.apache.lucene.analysis.en.PorterStemFilter;
//
///**
// *
// * @author Ali Souri
// */
//public class PositionalPorterStopAnalyzer extends Analyzer {
//private Set stopWords;
//public PositionalPorterStopAnalyzer() {
//this(StopAnalyzer.ENGLISH_STOP_WORDS_SET);
//}
//public PositionalPorterStopAnalyzer(Set stopWords) {
//this.stopWords = stopWords;
//}
//public TokenStream tokenStream(String fieldName, Reader reader) {
//StopFilter stopFilter = new StopFilter(true,
//new LowerCaseTokenizer(reader),
//stopWords);
//stopFilter.setEnablePositionIncrements(true);
//return new PorterStemFilter(stopFilter);
//}
//}