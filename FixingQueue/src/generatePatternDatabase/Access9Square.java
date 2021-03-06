package generatePatternDatabase;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class Access9Square {

	@Test
	public void test() throws IOException {
		String filename = "/home/edward/Research/generatePatternDBFiles/9Squareresults.out";
		RandomAccessFile f=new RandomAccessFile(filename, "r");
		byte [] bytes=new byte[(int) f.length()];
		f.readFully(bytes);
		int [] availableValues={1,2,3,4,5,6,7,8,0};

    	PatternDBSlidingSquareCollection tree=new PatternDBSlidingSquareCollection(availableValues, (byte)3, (byte)3, bytes);
    	byte[] dest={3,1,7,
    				2,8,4,
    				0,6,5};
		f.close();
	}

}
