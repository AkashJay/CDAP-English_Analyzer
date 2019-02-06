
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.util.StopwordAnalyzerBase;

/**
 * Created by akash on 2/5/19.
 */
public class Tester {

    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;


    public static void main(String[] args) {

        final CharArraySet STOP_WORDS_SET1 = StopAnalyzer.ENGLISH_STOP_WORDS_SET;
        System.out.println(STOP_WORDS_SET1);

//        CharArraySet stopSet = CharArraySet.copy(STOP_WORDS_SET1)
//        stopSet.add("how");
//        stopSet.add("when");
//        stopSet.add("from");
//        stopSet.add("you");
//        stopSet.add("can");
//        stopSet.add("get");

        String text = "then දෙවැනි plays in their  is with the played";


        List<String> stopWords = Arrays.asList(new String[]{"a", "දෙවැනි", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "there", "these", "they", "this", "to", "was", "will", "with"});
        CharArraySet stopSet = new CharArraySet(Version.LUCENE_CURRENT, stopWords, false);
        ENGLISH_STOP_WORDS_SE11T = CharArraySet.unmodifiableSet(stopSet);


        //StandardAnalyzer: Most sophisticated analyzer that consider general token types, lowercases, removes stop words and likewises
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42, ENGLISH_STOP_WORDS_SE11T);
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
