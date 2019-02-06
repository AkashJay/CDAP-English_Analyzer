
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.util.StopwordAnalyzerBase;

/**
 * Created by akash on 2/5/19.
 */
public class Tester {

    public static void main(String[] args) {
        String text = "plays in their is with the played";


        //StandardAnalyzer: Most sophisticated analyzer that consider general token types, lowercases, removes stop words and likewises
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
        List ss=TokenizeWithAnalyzer.tokenizeString(analyzer, text);
        System.out.print("==>"+ss+" \n");
    }


}




//The default stop words set in StandardAnalyzer and EnglishAnalyzer is from StopAnalyzer.ENGLISH_STOP_WORDS_SET, and they are:
//
//        "a", "an", "and", "are", "as", "at", "be", "but", "by",
//        "for", "if", "in", "into", "is", "it",
//        "no", "not", "of", "on", "or", "such",
//        "that", "the", "their", "then", "there", "these",
//        "they", "this", "to", "was", "will", "with"
//        StopFilter itself defines no default set of stop words.
