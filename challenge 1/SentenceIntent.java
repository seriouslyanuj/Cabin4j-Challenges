import java.util.Properties;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.util.CoreMap;

public class SentenceIntent {

    public static String findIntent(String sentence) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = pipeline.process(sentence);
        for (CoreMap sentence1 : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            String sentiment = sentence1.get(CoreAnnotations.SentimentClass.class);
            if (sentiment.equals("Positive")) {
                return "Positive";
            } else if (sentiment.equals("Negative")) {
                return "Negative";
            }
        }
        return "Neutral";
    }

    public static void main(String[] args) {
        String sentence1 = "What is the weather like today?";
        String sentence2 = "I am happy today!";
        String sentence3 = "I am sad today!";
        System.out.println(sentence1 + ": " + findIntent(sentence1));
        System.out.println(sentence2 + ": " + findIntent(sentence2));
        System.out.println(sentence3 + ": " + findIntent(sentence3));
    }
}
