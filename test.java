import com.asprise.ocr.Ocr

public class test{
	public static void main(String[] args) {
		Ocr.setUp();
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		String s = ocr.recognize(new File[] {new File("poster1.jpg")},
			Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		System.out.println("Result: " + s);
	}
}