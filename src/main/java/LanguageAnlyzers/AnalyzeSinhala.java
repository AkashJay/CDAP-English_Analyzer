package LanguageAnlyzers;

import CommonUtills.TextToString;
import CommonUtills.TokenizeWithAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.io.*;

public class AnalyzeSinhala {
    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;


    public static void main(String[] args) {
        //Document name incrementer
        int x = 0;
        //Directory path to files to be analyzed
        File dir = new File("/home/akash/Documents/TestPDocuments/");
        //Initiate StandardAnalyzer object
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);

        try {
            //Loop through alll the files in directory
            for (File file : dir.listFiles()) {
                x++;
                //Read text file to a string
                String fileAsString = TextToString.readTextFile(file);
                //Analyze the string using StandardAnalyzer
                String analyzedString= TokenizeWithAnalyzer.tokenizeString(analyzer, fileAsString);
                System.out.println(analyzedString);


                FileWriter fw=new FileWriter(".//"+ x +".txt");
                fw.write(analyzedString);
                fw.close();

            }
        }
        catch (FileNotFoundException e1) {
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println(e2);
        } catch (NullPointerException e3){
            System.out.println(e3);
        }



    }



}
