package document;

public class test {
	public static void main(String [ ] args) {
		//BasicDocument d = new BasicDocument("These are some sentences. These are some sentences. These are some sentences.");
		//int n = d.countSyllables("AAPLEUE");
		//System.out.println("found syllables" + n);
		
		//int cnt = d.getNumSentences();
		//System.out.println("found sentence" + cnt);
		
		//double score = d.getFleschScore();
		//System.out.println("score = " + score);
		
		String s = "\"%one%%two%%%three%%%%\"";
		String[] text = s.split("[one,two,three]");
		for (int i = 0; i < text.length; i++) {
			System.out.println(text[i]);
		}
	}
}
